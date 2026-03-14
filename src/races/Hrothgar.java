package races;

import main.*;

import java.util.*;

import main.Character.Sex;

/** Represents the Hrothgar and its specific stat bonuses */
public class Hrothgar extends Race {
    private HrothgarClan clanChoice;
    private final ArrayList<String> hrothMNames = new ArrayList<>(Arrays.asList("Borimir", "Deyan", "Grugur", "Mikac", "Ludevit", "Novak", "Semir", "Sudimir", "Svante", "Taman"));
    private final ArrayList<String> hrothFNames = new ArrayList<>(Arrays.asList("Anja", "Gunnhildr", "Hana", "Jana", "Katarina", "Maja", "Milena", "Petra", "Teodora"));
    private final ArrayList<String> helionNames = new ArrayList<>(Arrays.asList("Amilan", "Aredna", "Arodica", "Asvana", "Astana"));
    private final ArrayList<String> theLostNames = new ArrayList<>(Arrays.asList("Irryasch", "Mildasch", "Ovasch", "Petyasch", "Piryasch", "Zelasch"));

    /**
     * Represents the two distinct clans of the Hrothgar
     */
    public enum HrothgarClan {
        HELIONS, THE_LOST
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
        Random rand = new Random();
        if (clanChoice == HrothgarClan.HELIONS && sex == Sex.MALE) {
            return hrothMNames.get(rand.nextInt(hrothMNames.size())) + " " + helionNames.get(rand.nextInt(helionNames.size()));
        } else if (clanChoice == HrothgarClan.HELIONS && sex == Sex.FEMALE) {
            return hrothFNames.get(rand.nextInt(hrothFNames.size())) + " " + helionNames.get(rand.nextInt(helionNames.size()));
        } else if (clanChoice == HrothgarClan.THE_LOST && sex == Sex.MALE) {
            return hrothMNames.get(rand.nextInt(hrothMNames.size())) + " " + theLostNames.get(rand.nextInt(theLostNames.size()));
        } else {
            return hrothFNames.get(rand.nextInt(hrothFNames.size())) + " " + theLostNames.get(rand.nextInt(theLostNames.size()));
        }
    }

    /**
     * Constructs a new Hrothgar character, initializing their specific base stats,
     * walking speed, and racial traits.
     */
    public Hrothgar() {
        super();
        this.name = "Hrothgar";
        this.walkingSpeed = 30;
        this.description = "The Hrothgar are powerful, feline people from the Northeast who had struggles when meeting the other races of the world as they were unable to speak the common tongue. They call Ilsabard their homeland and they walk two distinct paths, one of servitude and the other of freedom. These distinct paths and ways of life led to the Helions, warm coloured Hrothgar who serve in the name of their Queen, and The Lost, cool coloured Hrothgar who value freedom above all else.";
        addBonus(Stat.STRENGTH, 2);
    }

    /**
     * Assigns the bonus racial stat points
     */
    protected void raceStats() {
        addBonus(Stat.STRENGTH, 2);
    }

    /**
     * {@inheritDoc}
     */
    public void pickClan(String clan) {
        startingStats();
        initialRaceBonuses.put(Stat.WISDOM, 2);
        String clanChoice = clan.toUpperCase().trim();

        if (clanChoice.equals("HELION") || clanChoice.equals("1")) {
            this.clanChoice = Hrothgar.HrothgarClan.HELIONS;
        } else if (clanChoice.equals("THE_LOST") || clanChoice.equals("2")) {
            this.clanChoice = Hrothgar.HrothgarClan.THE_LOST;
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
        if (clanChoice == HrothgarClan.HELIONS) {
            addBonus(Stat.DEXTERITY, 1);
        } else if (clanChoice == HrothgarClan.THE_LOST) {
            addBonus(Stat.CONSTITUTION, 1);
        }
    }

    /**
     *{@inheritDoc}
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

