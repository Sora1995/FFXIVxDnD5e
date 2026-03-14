package races;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import main.Character.Sex;
/** Represents the Miqo'te race and its specific stat bonuses */
public class Miqote extends Race {
    private final ArrayList<String> sunTribeChars = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
    private final ArrayList<String> sunMNames = new ArrayList<>(Arrays.asList("wheto", "ciwah", "tuja", "fhemeh", "chelu", "cuhguh", "tohm", "ghut", "bod", "phur"));
    private final ArrayList<String> sunFNames = new ArrayList<>(Arrays.asList("nhamfaule", "qhaalkamo", "mhagsoo", "ganni", "yhaafoqu", "gidhiju", "jotnhu", "keknhegu", "yhaiabdu", "zhamroli"));
    private final ArrayList<String> moonMNames = new ArrayList<>(Arrays.asList("Axah'a", "Gohkoh'to", "Luhga'li", "Mahgeh'sae", "Mucih'ra", "Nohpu'ir", "Sahxa'wo", "Suleh'ya", "Vehse'zi", "Wizo'tan"));
    private final ArrayList<String> moonFNames = new ArrayList<>(Arrays.asList("Nuhmu", "Ota", "Pehbi", "Vehba", "Yaba", "Miko", "Fafoh", "Cehxi", "Xarih", "Ecih"));
    private final ArrayList<String> moonSurnames = new ArrayList<>(Arrays.asList("Dagnheive", "Dopsha", "Gauvro", "Jadnhapo", "Jhendaka", "Khutnauyu", "Phemfa", "Mhento", "Rheibfuqe", "Ruyhaia"));
    private MiqoteClan clanChoice;

    /**
     * Represents the two distinct clans of the Miqo'te race
     */
    public enum MiqoteClan {
        SEEKERS_OF_THE_SUN, KEEPERS_OF_THE_MOON
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
        Random rand = new Random();
        String randomTribe = "";
        String randomFirstName = "";
        String randomLastName = "";

        if(clanChoice == MiqoteClan.SEEKERS_OF_THE_SUN && sex == Sex.MALE) {
            randomTribe = sunTribeChars.get(rand.nextInt(sunTribeChars.size()));
            randomFirstName = sunMNames.get(rand.nextInt(sunMNames.size()));
            return randomTribe + "'" + randomFirstName + " " + "Tia";
        } else if (clanChoice == MiqoteClan.SEEKERS_OF_THE_SUN && sex == Sex.FEMALE) {
            randomTribe = sunTribeChars.get(rand.nextInt(sunTribeChars.size()));
            randomFirstName = sunFNames.get(rand.nextInt(sunFNames.size()));
            randomLastName = sunMNames.get(rand.nextInt(sunMNames.size()));
            return randomTribe + "'" + randomFirstName + " " + randomLastName;
        } else if (clanChoice == MiqoteClan.KEEPERS_OF_THE_MOON && sex == Sex.MALE) {
            randomFirstName = moonMNames.get(rand.nextInt(moonMNames.size()));
            randomLastName = moonSurnames.get(rand.nextInt(moonSurnames.size()));
            return randomFirstName + " " + randomLastName;
        } else {
            randomFirstName = moonFNames.get(rand.nextInt(moonFNames.size()));
            randomLastName = moonSurnames.get(rand.nextInt(moonSurnames.size()));
            return randomFirstName + " " + randomLastName;
        }
    }

    /**
     * Constructs a new Miqo'te character, initializing their specific base stats,
     * walking speed, and racial traits.
     */
    public Miqote() {
        super();
        this.name = "Miqo'te";
        this.walkingSpeed = 30;
        this.description = "The Miqo'te are a second group of feline people who traveled to Eorzea across a frozen sea long ago. These proud people find pride in their natural hunting ability and have split into two distinct ethnic groups who worship the sun and moon respectively. The Seekers of the Sun live in warmer clients in patriarchal societies while The Keepers of the Moon live in dense forests, their tribes centering on matriarchs.";

        addBonus(Stat.DEXTERITY, 2);
        this.darkVisionRadius = 60;
    }

    /**
     * Assigns the bonus racial stat points
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

        if (clanChoice.equals("SEEKERS_OF_THE_SUN") ||clanChoice.equals("1")) {
            this.clanChoice = MiqoteClan.KEEPERS_OF_THE_MOON;
        } else if (clanChoice.equals("KEEPERS_OF_THE_MOON") || clanChoice.equals("2")) {
            this.clanChoice = MiqoteClan.SEEKERS_OF_THE_SUN;
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
        if (clanChoice == MiqoteClan.SEEKERS_OF_THE_SUN) {
            addBonus(Stat.CHARISMA, 1);
            this.walkingSpeed = 35;
        } else if (clanChoice == MiqoteClan.KEEPERS_OF_THE_MOON) {
            addBonus(Stat.WISDOM, 1);
            this.darkVisionRadius = 120; // 120 feet of dark vision;
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
