package races;
import main.*;

import java.util.*;

public class Hrothgar extends Race {
	private HrothgarClan clanChoice;
	private ArrayList<String> hrothMNames = new ArrayList<>(Arrays.asList("Borimir", "Deyan", "Grugur", "Mikac", "Ludevit", "Novak", "Semir", "Sudimir", "Svante", "Taman"));
	private ArrayList<String> hrothFNames = new ArrayList<>(Arrays.asList("Anja", "Gunnhildr", "Hana", "Jana", "Katarina", "Maja", "Milena", "Petra", "Teodora"));
	private ArrayList<String> helionNames = new ArrayList<>(Arrays.asList("Amilan", "Aredna", "Arodica", "Asvana", "Astana"));
	private ArrayList<String> theLostNames = new ArrayList<>(Arrays.asList("Irryasch", "Mildasch", "Ovasch", "Petyasch", "Piryasch", "Zelasch"));
	public enum HrothgarClan {
		HELIONS, THE_LOST
	}
	@Override
	public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
		Random rand = new Random();
		if (clanChoice == HrothgarClan.HELIONS && sex == Sex.MALE) {
			return hrothMNames.get(rand.nextInt(hrothMNames.size())) + " " + helionNames.get(rand.nextInt(helionNames.size()));
		} else if (clanChoice == HrothgarClan.HELIONS  && sex == Sex.FEMALE) {
			return hrothFNames.get(rand.nextInt(hrothFNames.size())) + " " + helionNames.get(rand.nextInt(helionNames.size()));
		} else if (clanChoice == HrothgarClan.THE_LOST  && sex == Sex.MALE) {
			return hrothMNames.get(rand.nextInt(hrothMNames.size())) + " " + theLostNames.get(rand.nextInt(theLostNames.size()));
		} else {
			return hrothFNames.get(rand.nextInt(hrothFNames.size())) + " " + theLostNames.get(rand.nextInt(theLostNames.size()));
		}
	}

	@Override
	public void printClanMenu() {

	}

	public Hrothgar() {
				super();
		this.name = "Hrothgar";
		this.walkingSpeed = 30;
		this.description = "The Hrothgar are powerful, feline people from the Northeast who had struggles when meeting the other races of the world as they were unable to speak the common tongue. They call Ilsabard their homeland and they walk two distinct paths, one of servitude and the other of freedom. These distinct paths and ways of life led to the Helions, warm coloured Hrothgar who serve in the name of their Queen, and The Lost, cool coloured Hrothgar who value freedom above all else.";
		addBonus(Stat.STRENGTH, 2);
	}
	protected void raceStats() {
		addBonus(Stat.STRENGTH, 2);
	}

	public void pickClan(String clan) {
		startingStats();
		initialRaceBonuses.put(Stat.WISDOM, 2);
		String clanChoice = clan.toUpperCase().trim();

		if(clanChoice.equals("HELION") || clanChoice.equals("1")) {
			this.clanChoice = Hrothgar.HrothgarClan.HELIONS;
		} else if(clanChoice.equals("THE_LOST") || clanChoice.equals("2")) {
			this.clanChoice = Hrothgar.HrothgarClan.THE_LOST;
		} else {
			System.out.println("Invalid clan choice");
			return;
		}
		raceStats();
		clanBonuses();
	}
	@Override
	public void clanBonuses( ) {
		if (clanChoice == HrothgarClan.HELIONS) {
			addBonus(Stat.DEXTERITY, 1);
		} else if (clanChoice ==  HrothgarClan.THE_LOST) {
			addBonus(Stat.CONSTITUTION, 1);
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

