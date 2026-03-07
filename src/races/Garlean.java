package races;
import main.PlayerChoices;

import java.util.*;

public class Garlean extends Race {
    private String title;
    public void setGarleanTitle(String title) {
        this.title = title;
    }
    public String getGarleanTitle() {
        return this.title;
    }


    private final ArrayList<String> garleanMNames = new ArrayList<>(Arrays.asList("Aulus", "Cid", "Faust", "Gaius", "Ignatius", "Kaius", "Maxima", "Nael", "Nero", "Noah", "Quentin", "Regula", "Solus", "Vitus", "Zenos"));
    private final ArrayList<String> garleanFNames = new ArrayList<>(Arrays.asList("Adora", "Alma", "Belva", "Cella", "Elysia", "Gloria", "Julia", "Livia", "Lucia", "Minverva", "Octavia", "Rheya", "Silvia", "Vesta"));
    private final ArrayList<String> garleanTitles = new ArrayList<>(Arrays.asList("oen", "pyr", "jen", "bas", "aan"));
    private final ArrayList<String> garleanSurnames = new ArrayList<>(Arrays.asList("Arvina", "Asina", "Baelsar", "Brutus", "Darunus", "Gabranth", "Galvus", "Garlond", "Hydra", "Junius", "Lexentale", "Messalla", "Priscus", "Scaeva"));

    @Override
    public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
        Random rand = new Random();
        String randomFirstName = "";
        String randomTitle;
        String randomSurname = "";

        if (sex == Sex.MALE) {
            randomFirstName = garleanMNames.get(rand.nextInt(garleanMNames.size()));
            randomSurname = garleanSurnames.get(rand.nextInt(garleanSurnames.size()));
        } else {
            randomFirstName = garleanFNames.get(rand.nextInt(garleanFNames.size()));
            randomSurname = garleanSurnames.get(rand.nextInt(garleanSurnames.size()));
        }

        String highestStat = "Strength";
        int maxVal = stats.getOrDefault("Strength", 0);

        for (String stat: stats.keySet()) {
            if (stats.get(stat) > maxVal) {
                maxVal = stats.get(stat);
                highestStat = stat;
            }
        }

        randomTitle = switch (highestStat) {
            case "Strength", "Constitution" -> "pyr";
            case "Intelligence" -> "jen";
            case "Charisma" -> "bas";
            default -> garleanTitles.get(rand.nextInt(garleanTitles.size()));
        };

        return randomFirstName + " " + randomTitle + " " + randomSurname;
    }

    @Override
    public void printClanMenu() {
        System.out.println("Garleans do not have clans; they use military and social titles instead.");
    }

    public Garlean() {
        super();
        this.name = "Garlean";
        this.walkingSpeed = 30;
        this.description = "The Garleans are physically strong and highly intelligent people who call the land of Ilsabard their home. They are marked by their third eye, a gem like growth in the center of their forehead. Unfortunately for them, the Garleans as a whole have great difficulty channeling aether through their bodies, which despite their physicality and intelligence, found themselves bowing to many other magic wielding races. They were eventually able to develop technology to make up for this lack of magical aptitude and turned the tables, establishing the Garlean Empire in Ilsabard, a dominate force which sought to invade the land of Eorzea.";
        addBonus(Stat.STRENGTH, 2);
        addBonus(Stat.INTELLIGENCE, 1);
    }

    @Override
    public void pickClan(String clan) {
        this.title = clan;
    }

    @Override
    public void clanBonuses() {

    }

    @Override
	public ArrayList<PlayerChoices> raceOptions() {
        ArrayList<PlayerChoices> choices = new ArrayList<>();
        ArrayList<String> garleanTitles = new ArrayList<>(Arrays.asList("oen", "pyr", "jen", "bas", "aan"));
        choices.add(new PlayerChoices("Pick a title for your Garlean:", garleanTitles));
        return choices;
    }

    @Override
    public void chosenVariables(String input) {
        setGarleanTitle(input);
    }
}
