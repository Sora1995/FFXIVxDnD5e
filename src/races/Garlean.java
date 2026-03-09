package races;
import main.PlayerChoices;

import java.util.*;

public class Garlean extends Race {
    private GarleanTitles title;
    public void setGarleanTitle(GarleanTitles title) {
        this.title = title;
    }
    public GarleanTitles getGarleanTitle() {
        return this.title;
    }
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
        public String getTitleDescription() {
            return this.titleDescription;
        }
    }



    private final ArrayList<String> garleanMNames = new ArrayList<>(Arrays.asList("Aulus", "Cid", "Faust", "Gaius", "Ignatius", "Kaius", "Maxima", "Nael", "Nero", "Noah", "Quentin", "Regula", "Solus", "Vitus", "Zenos"));
    private final ArrayList<String> garleanFNames = new ArrayList<>(Arrays.asList("Adora", "Alma", "Belva", "Cella", "Elysia", "Gloria", "Julia", "Livia", "Lucia", "Minverva", "Octavia", "Rheya", "Silvia", "Vesta"));
    private final ArrayList<String> garleanSurnames = new ArrayList<>(Arrays.asList("Arvina", "Asina", "Baelsar", "Brutus", "Darunus", "Gabranth", "Galvus", "Garlond", "Hydra", "Junius", "Lexentale", "Messalla", "Priscus", "Scaeva"));

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

        String highestStat = "Strength";
        int maxVal = stats.getOrDefault("Strength", 0);

        for (String stat: stats.keySet()) {
            if (stats.get(stat) > maxVal) {
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

        return randomFirstName + " " + randomTitle + " " + randomSurname;
    }

    @Override
    public void printClanMenu() {
        System.out.println("Garleans do not have clans; they use military and social titles instead.");
    }


    public Garlean() {
        this.name = "Garlean";
        this.walkingSpeed = 30;
        this.description = "The Garleans are physically strong and highly intelligent people who call the land of Ilsabard their home. They are marked by their third eye, a gem like growth in the center of their forehead. Unfortunately for them, the Garleans as a whole have great difficulty channeling aether through their bodies, which despite their physicality and intelligence, found themselves bowing to many other magic wielding races. They were eventually able to develop technology to make up for this lack of magical aptitude and turned the tables, establishing the Garlean Empire in Ilsabard, a dominate force which sought to invade the land of Eorzea.";
        addBonus(Stat.STRENGTH, 2);
        addBonus(Stat.INTELLIGENCE, 1);
    }

    public void pickClan(String clan) {
        setGarleanTitle(GarleanTitles.valueOf(clan.toUpperCase()));
    }

    @Override
    public void clanBonuses() {

    }

    @Override
	public ArrayList<PlayerChoices> raceOptions() {
        return null;
    }

    @Override
    public void chosenVariables(String input) {
        setGarleanTitle(GarleanTitles.valueOf(input.toUpperCase()));
    }
}
