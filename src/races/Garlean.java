package races;
import main.PlayerChoices;
import main.Character.Sex;
import java.util.*;

/** Represents the Garlean race and its specific stat bonuses */
public class Garlean extends Race {
    private GarleanTitles title;

    /**
     * Sets the Garlean title that is assigned to the character
     * @param title The title being assigned to the character
     */
    public void setGarleanTitle(GarleanTitles title) {
        this.title = title;
    }

    /**
     * Gets the Garlean title and returns it
     * @return the title assigned to the Garlean character
     */
    public GarleanTitles getGarleanTitle() {
        return this.title;
    }

    /**
     * Represents each of the titles of the Garlean Empire with descriptions
     */
    public enum GarleanTitles {
        ZOS("Supreme leader of Garlamald"),
        YAE("Royal family member in line for the throne"),
        WIR("Royal family member with no claim to the throne"),
        VAN("Commander of one or many legions"),
        TOL("Secondary Command within a legion"),
        SAS("Commander of fort or base of operations"),
        REM("Commander of one of the legion's cohorts"),
        QUO("Commander of a mid-sized unit of at least 100 soldiers"),
        PYR("Watch Commander or Veteran soldier"),
        OEN("Regular Infantry of the Empire"),
        NAN("Head of Magitek Research or an Engineer specializing in Magitek"),
        MAL("High Commander of Field Engineers or Field Medics"),
        LUX("Commander of a unit of Medics or Field Engineers"),
        KIR("Veteran field medic or engineer"),
        JEN("Field Medic or Engineer"),
        IYL("Leader of the Senate"),
        HET("Various Magistrates of High Standing"),
        GOE("Local Ruler of Imperial Territory or Commander of operatives"),
        FAE("Senators who work to elect Magistrates"),
        EIR("High level civil servants"),
        DUS("Low level civil servants"),
        CEN("Artisans and manufacturers"),
        BAS("Merchants and workers who gather raw materials"),
        AAN("Slaves and the people of annexed territories"),
        VIATOR("Outcasts and enemies of Garlamald");

        private final String titleDescription;
        GarleanTitles(String description) {
            this.titleDescription = description;
        }

        /**
         * Gets the description of the Garlean title
         * @return the description of the title
         */
        public String getTitleDescription() {
            return this.titleDescription;
        }
    }



    private final ArrayList<String> garleanMNames = new ArrayList<>(Arrays.asList("Aulus", "Cid", "Faust", "Gaius", "Ignatius", "Kaius", "Maxima", "Nael", "Nero", "Noah", "Quentin", "Regula", "Solus", "Vitus", "Zenos"));
    private final ArrayList<String> garleanFNames = new ArrayList<>(Arrays.asList("Adora", "Alma", "Belva", "Cella", "Elysia", "Gloria", "Julia", "Livia", "Lucia", "Minverva", "Octavia", "Rheya", "Silvia", "Vesta"));
    private final ArrayList<String> garleanSurnames = new ArrayList<>(Arrays.asList("Arvina", "Asina", "Baelsar", "Brutus", "Darunus", "Gabranth", "Galvus", "Garlond", "Hydra", "Junius", "Lexentale", "Messalla", "Priscus", "Scaeva"));

    /**
     * A special random name generator that implements the Garlean titles, allowing generation of a set list of random titles based on stats
     * @param sex The sex of the character, used to determine first name
     * @param stats The stats that were rolled from the dice. If there's a tie, defaults to the first in the List
     * @return The formatted string containing the character's first name, chosen title, and last name
     */
    @Override
    public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
        Random rand = new Random();
        String randomFirstName;
        GarleanTitles randomTitle;
        String randomSurname;

        if (sex == Sex.MALE) {
            randomFirstName = garleanMNames.get(rand.nextInt(garleanMNames.size()));
        } else {
            randomFirstName = garleanFNames.get(rand.nextInt(garleanFNames.size()));
        }
        randomSurname = garleanSurnames.get(rand.nextInt(garleanSurnames.size()));
        String[] statPriority = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        String highestStat = "Strength";
        int maxVal = -1;

        for (String stat: statPriority) {
            if (stats.getOrDefault(stat, -1) > maxVal) {
                maxVal = stats.get(stat);
                highestStat = stat;
            }
        }

        randomTitle = switch (highestStat) {
            case "Strength", "Constitution" -> GarleanTitles.PYR;
            case "Intelligence" -> GarleanTitles.JEN;
            case "Charisma" -> GarleanTitles.BAS;
            default -> GarleanTitles.values()[rand.nextInt(GarleanTitles.values().length)];
        };

        return randomFirstName + " " + randomTitle.name().toLowerCase() + " " + randomSurname;
    }

    /**
     * Constructs a new Garlean character, initializing their specific base stats,
     * walking speed, and racial traits.
     */
    public Garlean() {
        this.name = "Garlean";
        this.walkingSpeed = 30;
        this.description = "The Garleans are physically strong and highly intelligent people who call the land of Ilsabard their home. They are marked by their third eye, a gem like growth in the center of their forehead. Unfortunately for them, the Garleans as a whole have great difficulty channeling aether through their bodies, which despite their physicality and intelligence, found themselves bowing to many other magic wielding races. They were eventually able to develop technology to make up for this lack of magical aptitude and turned the tables, establishing the Garlean Empire in Ilsabard, a dominate force which sought to invade the land of Eorzea.";
        addBonus(Stat.STRENGTH, 2);
        addBonus(Stat.INTELLIGENCE, 1);
    }

    /**
     *{@inheritDoc}
     */
    public void pickClan(String clan) {
        setGarleanTitle(GarleanTitles.valueOf(clan.toUpperCase()));
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void clanBonuses() {

    }

    /**
     *{@inheritDoc}
     */
    @Override
	public ArrayList<PlayerChoices> raceOptions() {
        return null;
    }

    /**
     *{@inheritDoc}
     */
    @Override
    public void chosenVariables(String input) {
        setGarleanTitle(GarleanTitles.valueOf(input.toUpperCase()));
    }
}
