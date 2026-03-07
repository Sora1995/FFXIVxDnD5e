package races;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Lalafell extends Race {
    private ArrayList<String> plainsMNames = new ArrayList<>(Arrays.asList("Budadi Yidadi", "Egul Sagul", "Erelo Forelo", "Elehul Pedulehul", "Gusis Shisis"));
    private ArrayList<String> plainsFNames = new ArrayList<>(Arrays.asList("Icucu Icu", "Badada Bada", "Usoso Uso", "Kikuku Kiku"));
    private ArrayList<String> dunesMNames = new ArrayList<>(Arrays.asList("Wowokima Chichikima", "Sheshehici Rorohici", "Hihihebo Ruruhebo", "Tutushuhu Kukushuhu", "Gogoreba Susureba"));
    private ArrayList<String> dunesFNames = new ArrayList<>(Arrays.asList("Ejaja Eja", "Babayi Bayi", "Rerega Rega", "Chochosha Chosha", "Bobochu Bochu", "Lelepu Lepu"));
    private LalafellClan clanChoice;

    public enum LalafellClan {
        PLAINSFOLK, DUNESFOLK
    }

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

    @Override
    public void printClanMenu() {

    }


    public Lalafell() {
        super();
        this.name = "Lalafell";
        this.walkingSpeed = 25;
        this.description = "The Lalafell immigrated from Southern islands to Eorzea forming two distinct groups based on the geography their ancestors settled in. The darker skinned Dunesfolk formed the city state of Ul’dah in the deserts of Thanalan, while the lighter skinned Planesfolk settled and farmed the lands of La Noscea, a large island off the mainland of Eorzea. Both of these naturally charming folk found great success as merchants through history.";
    }
    protected void raceStats() {
        addBonus(Stat.CHARISMA, 2);
    }
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

    @Override
    public void clanBonuses() {
        if (clanChoice.equals(LalafellClan.PLAINSFOLK)) {
            addBonus(Stat.DEXTERITY, 1);
        } else if (clanChoice.equals(LalafellClan.DUNESFOLK)) {
            addBonus(Stat.INTELLIGENCE, 1);
        }
    }

    @Override
    public ArrayList<PlayerChoices> raceOptions() {
        return null;
    }

    @Override
    public void chosenVariables(String input) {

    }
}

