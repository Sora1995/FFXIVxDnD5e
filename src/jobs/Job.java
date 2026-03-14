package jobs;
import main.PlayerChoices;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class lays the groundwork for all jobs (Pictomancer, Sage, Bard, etc.)
 * It controls the core of the jobs, including HP, spells and cantrips, and standard job logic.
 *
 * @author Sora1995
 */
public abstract class Job {
    protected String name;
    protected String description;

    protected String hitDice;
    protected int baseHP;
    protected String savingThrows;

    protected ArrayList<String> proficiencies;
    protected ArrayList<String> startingEquipment;

    protected ArrayList<String> knownCantrips;
    protected ArrayList<String> firstLevelSpells;
    protected int numCantrips;

    protected int[] spellSlots;

    protected int numSpells;

    /**
     * Gets a list of martial weapons for the player to pick from
     * @return ArrayList returns an ArrayList of martial weapons
     */
    protected ArrayList<String> getMartialWeaponsList() {
        return new ArrayList<>(Arrays.asList("Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halberd", "Lance", "Longsword", "Maul", "Morningstar", "Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War Pick", "Warhammer", "Whip"));
    }

    /**
     * Gets a list of simple weapons for the player to pick from
     * @return ArrayList
     */
    protected ArrayList<String> getSimpleWeaponsList() {
        return new ArrayList<>(Arrays.asList("Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear", "Light Crossbow", "Dart", "Shortbow", "Sling"));
    }

    protected PlayerChoices getValidSimpleWeaponChoice() {
        return new PlayerChoices("Choose one of the following simple weapons: ", getSimpleWeaponsList());
    }

    protected ArrayList<String> getArtisanToolsList() {
        return new ArrayList<>(Arrays.asList("Alchemist's supplies", "Brewer's supplies", "Calligrapher's supplies", "Carpenter's tools", "Cartographer's tools", "Cobbler's tools", "Cook's utensils", "Glassblower's tools", "Jeweler's tools", "Leatherworker's tools", "Mason's tools", "Painter's supplies", "Potter's tools", "Smith's tools", "Tinker's tools", "Weaver's tools", "Woodcarver's tools"));
    }

    protected PlayerChoices getValidArtisanTools() {
        return new PlayerChoices("You get a set of artisan's tools of your choice. Please pick from the following: ", getArtisanToolsList());
    }

    protected ArrayList<String> getMusicalInstrumentsList() {
        return new ArrayList<>(Arrays.asList("Bagpipes", "Drum", "Dulcimer", "Flute", "Lute", "Lyre", "Horn", "Pan flute", "Shawm", "Viol"));
    }

    /**
     * Job constructor
     */
    public Job() {
        this.proficiencies = new ArrayList<>();
        this.startingEquipment = new ArrayList<>();
        this.knownCantrips = new ArrayList<>();
        this.firstLevelSpells = new ArrayList<>();
        this.spellSlots = new int[10];
    }

    /**
     * Gets the name of the job the player chose
     * @return name The name of the job
     */
    public String getJobName() {
        return name;
    }

    /**
     * Gets the HP of the character by taking the base HP and adding the Constitution modifier
     * @param conModifier The character's unique constitution modifier, calculated as the constitution stat
     *                    minus ten, then divided by 2
     * @return A minimum HP the user can have with a bad modifier. Insures it does not drop below 1
     */
    public int getHP(int conModifier) {
        return Math.max(1, baseHP + conModifier);
    }

    /**
     * Adds specialized job options to the character, such as startin equipment, hit die, and saving throws
     */
    public abstract ArrayList<PlayerChoices> addJobOptions();

    /**
     * Adds equipment to the ArrayList for starting equipment the user selects throughout the process
     * @param item The item being added to the array
     */
    public void addEquipment(String item) {
        startingEquipment.add(item);
    }

    /**
     * Applies the job and associated info to the character
     * @throws IOException throws IOE if file can't be found for cantrip/spells
     */
    public abstract void applyJob() throws IOException;

    /**
     * Prints the inventory of equipment the user picks throughout the process
     */
    public void printInventory() {
        System.out.println("Inventory: " + startingEquipment);
    }

    /**
     * Gets the saving throws for the job
     * @return the saving throws for the job
     */
    public String getSavingThrows() {
        return savingThrows;
    }

    /**
     * Gets the description for each job
     * @return the description of the job
     */
    public String getDescription() {
        return description;
    }

    /**
     * Loads a list of spells and cantrips from two files
     * @throws IOException if file cannot be found, throw IOE
     */
    public void startingSpells() throws IOException {
        String searchTag = this.getJobName().toUpperCase().replace(" ", "");
        this.knownCantrips = loadFromFile("src/resources/cantrips.txt", searchTag);
        this.firstLevelSpells = loadFromFile("src/resources/spells.txt", searchTag);
    }

    /**
     * Randomly picks a set of cantrips and 1st level spells, reading from a text file to pick from
     *
     * @throws IOException If the file cannot be found or the spells could not be loaded, throws IOE
     * @param filePath The exact path to the file to read from
     * @param tag The string that identifies the start and end of each job's lists of spells and cantrips
     * @return the randomly picked spells and cantrips
     */
    public ArrayList<String> loadFromFile(String filePath, String tag) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String cleanedTarget = tag.replace(" ", "").toUpperCase();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean inSection = false;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String cleanedString = line.replace(" ", "").toUpperCase();
                if (inSection && line.startsWith("#")) {
                    break;
                }
                if (!inSection && cleanedString.equals("#" + cleanedTarget)) {
                    inSection = true;
                    continue;
                }

                if (inSection) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Could not load spells for " + tag + ": " + e.getMessage());
        }
        return list;
    }
    /**
     * Randomly picks a spell for magic users from the list of spells and canptrips, limited by the slots available
     * @param spellList The list of spells as a txt
     * @param slots The amount of slots available to put spells in
     * @return An ArrayList of spells that can be cast from, limited exactly to the slots
     */
    ArrayList<String> pickRandomSpell(ArrayList<String> spellList, int slots) {
        if (spellList == null || spellList.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> copy = new ArrayList<>(spellList);
        Collections.shuffle(copy);
        int finalCount = Math.min(slots, copy.size());
        return new ArrayList<>(copy.subList(0, finalCount));

    }

    /**
     * Gets the list of known cantrips the job can learn
     * @return knownCantrips returns the ArrayList of cantrips for a job
     */
    public ArrayList<String> getKnownCantrips() {
        return knownCantrips;
    }

    /**
     * Gets the list of first level spells the job can learn
     * @return firstLevelSpells Returns the ArrayList of first level spells for a job
     */
    public ArrayList<String> getFirstLevelSpells() {
        return firstLevelSpells;
    }
}
