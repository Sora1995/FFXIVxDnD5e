package races;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class Roegadyn extends Race {
	private RoegadynClan clanChoice;
	private ArrayList<String> roeMSeaWolvesNames = new ArrayList<>(Arrays.asList("Klynnahct", "Flazfolg", "Roehahtyn", "Broenstymm", "Haergeiss", "Nedyrsatz", "Unsynfarr"));
	private ArrayList<String> roeFSeaWolvesNames = new ArrayList<>(Arrays.asList("Rhotbryda", "Hezzwyb", "Rhenbryda", "Grynegeim", "Ketenbryda", "Skaenswys", "Swozthota", "Wyznthota", "Rhotbryda", "Trahggeim"));
	private ArrayList<String> roeMHellNames = new ArrayList<>(Arrays.asList("Aware Sun", "Major Wind", "Blue Yew", "Grateful Forest", "Surprised Cavern", "Bright Island", "Flawed Lake", "Fearless Oak", "Dirt Snow", "Stark Crow"));
	private ArrayList<String> roeFHellNames = new ArrayList<>(Arrays.asList("Soft Pea", "Obedient Apple", "Honored Eclipse", "Orange Autumn", "Silly Feather", "Carefree Locust", "Secret Lavender", "Careful Vapor", "Optimistic Blossom", "Innocent Daffodil"));
	public enum RoegadynClan {
		SEA_WOLVES, HELLSGUARD
	}
	@Override
	public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
		Random rand = new Random();
		if (clanChoice == RoegadynClan.SEA_WOLVES && sex == Sex.MALE) {
			return roeMSeaWolvesNames.get(rand.nextInt(roeMSeaWolvesNames.size()));
		} else if (clanChoice == RoegadynClan.SEA_WOLVES && sex == Sex.FEMALE) {
			return roeFSeaWolvesNames.get(rand.nextInt(roeFSeaWolvesNames.size()));
		} else if (clanChoice == RoegadynClan.HELLSGUARD&& sex == Sex.MALE) {
			return roeMHellNames.get(rand.nextInt(roeMHellNames.size()));
		} else {
			return roeFHellNames.get(rand.nextInt(roeFHellNames.size()));
		}
	}

	@Override
	public void printClanMenu() {

	}

	public Roegadyn() {
		super();
		this.name = "Roegadyn";
		this.walkingSpeed = 30;
		this.description = "The Roegadyn are large, hulking people who hail from the mountains and the sea. The Sea Wolves are known as famed pirates and settled the coastal city state Limsa Lominsa, while the Hellsguard live in villages atop mountains and volcanoes, acting as keepers of the land, believing such locations to be portals to other worlds.";
		addBonus(Stat.CONSTITUTION, 2);
	}
	protected void raceStats() {
		addBonus(Stat.CONSTITUTION, 2);
	}
	public void pickClan(String clan) {
		startingStats();
		initialRaceBonuses.put(Stat.CONSTITUTION, 2);
		String clanChoice = clan.toUpperCase().trim();

		if (clanChoice.equalsIgnoreCase("SEA WOLVES") ||clanChoice.equals("1")) {
			this.clanChoice = Roegadyn.RoegadynClan.SEA_WOLVES;
		} else if (clanChoice.equalsIgnoreCase("HELLSGUARD") || clanChoice.equals("2")) {
			this.clanChoice = Roegadyn.RoegadynClan.HELLSGUARD;
		} else {
			System.out.println("Invalid clan choice");
			return;
		}
		raceStats();
		clanBonuses();

	}
	@Override
	public void clanBonuses() {
		if (clanChoice == RoegadynClan.SEA_WOLVES) {
			addBonus(Stat.STRENGTH, 1);
		} else if (clanChoice == RoegadynClan.HELLSGUARD) {
			addBonus(Stat.CHARISMA, 1);
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

