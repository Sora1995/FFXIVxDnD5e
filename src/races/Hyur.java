package races;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Hyur extends Race {
    private HyurClan clanChoice;
    private Stat hyurStat;
    private ArrayList<String> midMNames = new ArrayList<>(Arrays.asList("Odard", "Redwald", "Kenward", "Herebert", "Acwuld", "Edward", "Roderic", "Eadwine"));
    private ArrayList<String> midFNames = new ArrayList<>(Arrays.asList("Rowena", "Hilda", "Agatha", "Hrodwyn", "Goldyna", "Hounild", "Edusa", "Beyhild", "Mathilda", "Tonild", "Somerhild", "Rimilde"));
    private ArrayList<String> highMNames = new ArrayList<>(Arrays.asList("Sigmundr", "Arnar", "Armond", "Varin", "Bard", "Hordr", "Ogmundr", "Hallgrim", "Thordr", "Raubahn"));
    private ArrayList<String> highFNames = new ArrayList<>(Arrays.asList("Marte", "Cathrine", "Yngvildr", "Helene", "Kolgrima", "Katie", "Myrun", "Kaolin", "Kaia", "Kamilla"));
    private ArrayList<String> midSurnames = new ArrayList<>(Arrays.asList("Taylor", "Faulkner", "Browne", "Parker", "Forrest", "River", "Miller", "Draper", "Fletcher", "Hill", "Thatcher"));
    private ArrayList<String> highSurnames = new ArrayList<>(Arrays.asList("Fury", "Burne", "Savage", "Stronge", "Strongaxe", "Blood", "Furor", "Shatterfist", "Strongblade", "Ironwill"));
    public enum HyurClan {
        MIDLANDERS, HIGHLANDERS, PADJAL
    }

    @Override
    public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
        return "";
    }

    @Override
    public void printClanMenu() {

    }

    public Hyur() {
        super();
        this.name = "Hyur";
        this.walkingSpeed = 30;
        this.description = "The Hyur have spread across the entirety of the world, making it difficult to trace what their homeland truly is. There are the average sized Midlanders, named for the elevation in which their sub species lived for many years, and the taller, more muscular highlanders, who lived in the high mountains for their declared homeland.";
    }

    public void pickClan(String clan) {
        startingStats();
        initialRaceBonuses.put(Stat.WISDOM, 2);
        String clanChoice = clan.toUpperCase().trim();

        if(clanChoice.equals("MIDLANDERS") || clanChoice.equals("1")) {
            this.clanChoice = HyurClan.MIDLANDERS;
        } else if(clanChoice.equals("HIGHLANDERS") || clanChoice.equals("2")) {
            this.clanChoice = HyurClan.HIGHLANDERS;
        } else if (clanChoice.equals("PADJAL") || clanChoice.equals("3")) {
            this.clanChoice = HyurClan.PADJAL;
        } else {
            System.out.println("Invalid clan choice");
            return;
        }
        clanBonuses();
    }

    @Override
    public void clanBonuses() {
        if (clanChoice == HyurClan.MIDLANDERS) {
            addBonus(Stat.INTELLIGENCE, 2);
        } else if (clanChoice == HyurClan.HIGHLANDERS) {
            addBonus(Stat.STRENGTH, 2);
        } else if (clanChoice == HyurClan.PADJAL) {
            addBonus(Stat.WISDOM, 2);
        }
    }

    @Override
    public ArrayList<PlayerChoices> raceOptions() {
        ArrayList<PlayerChoices> options = new ArrayList<>();
        options.add(new PlayerChoices("What stat would you like to add 1 to?", Arrays.asList("Strength", "Dexterity", "Constitution", "Wisdom", "Intelligence", "Charisma")));
        return options;
    }

    public void hyurBonus(Stat choice) {
        this.hyurStat = choice;
        startingStats();
        clanBonuses();
		addBonus(choice, 1);
		System.out.println("+1 additional bonus added to " + choice);
	}
    @Override
    public void chosenVariables(String input) {
        if(input.equalsIgnoreCase("Strength")) {
            hyurBonus(Stat.STRENGTH);
        } else if(input.equalsIgnoreCase("Dexterity")) {
            hyurBonus(Stat.DEXTERITY);
        } else if(input.equalsIgnoreCase("Constitution")) {
            hyurBonus(Stat.CONSTITUTION);
        }  else if(input.equalsIgnoreCase("Wisdom")) {
            hyurBonus(Stat.WISDOM);
        }  else if(input.equalsIgnoreCase("Intelligence")) {
            hyurBonus(Stat.INTELLIGENCE);
        } else if(input.equalsIgnoreCase("Charisma")) {
            hyurBonus(Stat.CHARISMA);
        } else {
            System.out.println("Invalid choice");
        }
    }
}
