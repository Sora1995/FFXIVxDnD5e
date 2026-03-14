package races;
import main.PlayerChoices;

import java.util.*;
import main.Character.Sex;

/** Represents the Elezen race and its specific stat bonuses */
public class Elezen extends Race {
	private ElezenClan clanChoice;
	private final ArrayList<String>  elezenMNames = new ArrayList<>(Arrays.asList("Adeux", "Beichault", "Dreauchant", "Eauplaux", "Etrent", "Gloffaux", "Jodeaux", "Joyent", "Ulmant", "Ulwex"));
	private final ArrayList<String>  elezenFNames = new ArrayList<>(Arrays.asList("Adreanne", "Iflione", "Eaupline", "Eranne", "Etrene", "Moriene", "Peronne", "Cummone", "Phivonne", "Paxeonne"));
	private final ArrayList<String> elezenSurnames = new ArrayList<>(Arrays.asList("Breaunojuste", "Douvionne", "Feajorins", "Gehon", "Glauvefand", "Grurubont", "Nahame", "Prihaux", "Shogamie", "Zuhepane"));

	/**
	 * Represents the three distinct clans of the Elezen race
	 */
	public enum ElezenClan {
		WILDWOOD, DUSKWIGHT, ISHGARDIAN
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
		Random rand = new Random();
		String randomFirstName = "";
		String randomLastName = "";

		if(clanChoice == ElezenClan.WILDWOOD && sex == Sex.MALE) {
			randomFirstName = elezenMNames.get(rand.nextInt(elezenMNames.size()));
			randomLastName = elezenSurnames.get(rand.nextInt(elezenSurnames.size()));
		} else if (clanChoice == ElezenClan.WILDWOOD && sex == Sex.FEMALE) {
			randomFirstName = elezenFNames.get(rand.nextInt(elezenFNames.size()));
			randomLastName = elezenSurnames.get(rand.nextInt(elezenSurnames.size()));
		} else if (clanChoice == ElezenClan.DUSKWIGHT && sex == Sex.MALE) {
			randomFirstName = elezenMNames.get(rand.nextInt(elezenMNames.size()));
			randomLastName = elezenSurnames.get(rand.nextInt(elezenSurnames.size()));
		} else if (clanChoice == ElezenClan.DUSKWIGHT && sex == Sex.FEMALE) {
			randomFirstName = elezenFNames.get(rand.nextInt(elezenFNames.size()));
			randomLastName = elezenSurnames.get(rand.nextInt(elezenSurnames.size()));
		} else if (clanChoice == ElezenClan.ISHGARDIAN && sex == Sex.MALE) {
			randomFirstName = elezenFNames.get(rand.nextInt(elezenFNames.size()));
			randomLastName = elezenSurnames.get(rand.nextInt(elezenSurnames.size()));
		} else {
			randomFirstName = elezenFNames.get(rand.nextInt(elezenFNames.size()));
			randomLastName = elezenSurnames.get(rand.nextInt(elezenSurnames.size()));
		}
		return randomFirstName + " " + randomLastName;
	}

	/**
	 * Constructs a new Elezen character, initializing the base stats including walking speed
	 */
    public Elezen() {
		super();
		this.name = "Elezen";
		this.walkingSpeed = 30;
		this.description = "The Elezen are elves who hail from Eorzea who call the lands of Gridania and Ishgard their home. Taller than regular elves, they have naturally good eyesight and are well intuned with the land. Over time they split into two groups, the Wildwood whom are light skinned and dextrous, skilled with a bow and live in either dense forests or their highly religious city-state homeland. Their relatives the Duskwights live in a series of twisting tunnels and ruins underground, coming up only to hunt for food or pillage before returning to their cavernous homes.";
	}

	/**
	 * Assigns the bonus racial stat points
	 */
	protected void raceStats() {
		addBonus(Stat.INTELLIGENCE, 2);
	}

	/**
	 * {@inheritDoc}
	 */
	public void pickClan(String clan) {
		startingStats();
		initialRaceBonuses.put(Stat.INTELLIGENCE, 2);
		String clanChoice = clan.toUpperCase().trim();

		if(clanChoice.equals("WILDWOOD") || clanChoice.equals("1")) {
			this.clanChoice = Elezen.ElezenClan.WILDWOOD;
		} else if(clanChoice.equals("DUSKWIGHT") || clanChoice.equals("2")) {
			this.clanChoice = ElezenClan.DUSKWIGHT;
		} else if(clanChoice.equals("ISHGARDIAN") || clanChoice.equals("3")) {
			this.clanChoice = Elezen.ElezenClan.ISHGARDIAN;
		}else {
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
		if (clanChoice == ElezenClan.WILDWOOD) {
			addBonus(Stat.DEXTERITY, 1);
		} else if (clanChoice == ElezenClan.DUSKWIGHT) {
			addBonus(Stat.CONSTITUTION, 1);
		} else if (clanChoice ==  ElezenClan.ISHGARDIAN) {
			addBonus(Stat.STRENGTH, 1);
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
	 *{@inheritDoc}
	 */
	@Override
	public void chosenVariables(String input) {

	}
}
