package races;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import main.Character.Sex;

/** Represents the Lalafell race and its specific stat bonuses */
public class Lalafell extends Race {
    private final ArrayList<String> plainsMNames = new ArrayList<>(Arrays.asList("Budadi Yidadi", "Egul Sagul", "Erelo Forelo", "Elehul Pedulehul", "Gusis Shisis"));
    private final ArrayList<String> plainsFNames = new ArrayList<>(Arrays.asList("Icucu Icu", "Badada Bada", "Usoso Uso", "Kikuku Kiku"));
    private final ArrayList<String> dunesMNames = new ArrayList<>(Arrays.asList("Wowokima Chichikima", "Sheshehici Rorohici", "Hihihebo Ruruhebo", "Tutushuhu Kukushuhu", "Gogoreba Susureba"));
    private final ArrayList<String> dunesFNames = new ArrayList<>(Arrays.asList("Ejaja Eja", "Babayi Bayi", "Rerega Rega", "Chochosha Chosha", "Bobochu Bochu", "Lelepu Lepu"));
    private LalafellClan clanChoice;

    /**
     * Represents the two distinct clans of the Lalafell
     */
    public enum LalafellClan {
        PLAINSFOLK, DUNESFOLK
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
        Random rand = new Random();
        if (clanChoice == LalafellClan.PLAINSFOLK && sex == Sex.MALE) {
            return plainsMNames.get(rand.nextInt(plainsMNames.size()));
        } else if (clanChoice == LalafellClan.PLAINSFOLK && sex == Sex.FEMALE) {
            return plainsFNames.get(rand.nextInt(plainsFNames.size()));
        } else if (clanChoice == LalafellClan.DUNESFOLK && sex == Sex.MALE) {
            return dunesMNames.get(rand.nextInt(dunesMNames.size()));
        } else {
            return dunesFNames.get(rand.nextInt(dunesFNames.size()));
        }
    }

    /**
     * Constructs a new Lalafell character, initializing their specific base stats,
     * walking speed, and racial traits.
     */
    public Lalafell() {
        super();
        this.name = "Lalafell";
        this.walkingSpeed = 25;
        this.description = "The Lalafell immigrated from Southern islands to Eorzea forming two distinct groups based on the geography their ancestors settled in. The darker skinned Dunesfolk formed the city state of Ul’dah in the deserts of Thanalan, while the lighter skinned Planesfolk settled and farmed the lands of La Noscea, a large island off the mainland of Eorzea. Both of these naturally charming folk found great success as merchants through history.";
    }

    /**
     * Assigns the bonus racial stat
     */
    protected void raceStats() {
        addBonus(Stat.CHARISMA, 2);
    }

    /**
     * {@inheritDoc}
     */
    public void pickClan(String clan) {
        startingStats();
        initialRaceBonuses.put(Stat.CHARISMA, 2);
        String clanChoice = clan.toUpperCase().trim();

        if (clanChoice.equals("PLAINSFOLK") ||clanChoice.equals("1")) {
            this.clanChoice = LalafellClan.PLAINSFOLK;
        } else if (clanChoice.equals("DUNESFOLK") || clanChoice.equals("2")) {
            this.clanChoice = LalafellClan.DUNESFOLK;
        } else {
            System.out.println("Invalid clan choice");
            return;
        }
        raceStats();
        clanBonuses();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clanBonuses() {
        if (clanChoice.equals(LalafellClan.PLAINSFOLK)) {
            addBonus(Stat.DEXTERITY, 1);
        } else if (clanChoice.equals(LalafellClan.DUNESFOLK)) {
            addBonus(Stat.INTELLIGENCE, 1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> raceOptions() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void chosenVariables(String input) {

    }
}

