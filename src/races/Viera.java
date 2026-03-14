package races;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import main.Character.Sex;
/** Represents the Viera race and its specific stat bonuses */
public class Viera extends Race {
	private VieraClan clanChoice;
	private final ArrayList<String> vieraMNames = new ArrayList<>(Arrays.asList("Atan", "Morn", "Tjln", "Frjn"));
	private final ArrayList<String> vieraFNames = new ArrayList<>(Arrays.asList("Fran", "Jote", "Mjrn", "Kryn", "Ktjn"));
	public enum VieraClan {
		RAVA, VEENA
	}

	/**
	 *{@inheritDoc}
	 */
	@Override
	public String randomNameGenerator(Sex sex, HashMap<String, Integer> stats) {
		Random rand = new Random();
		if (sex == Sex.MALE) {
			return vieraMNames.get(rand.nextInt(vieraMNames.size()));
		} else {
			return vieraFNames.get(rand.nextInt(vieraFNames.size()));
		}
	}
	/**
	 * Constructs a new Viera character, initializing their specific base stats,
	 * walking speed, and racial traits.
	 */
	public Viera() {
				super();
		this.name = "Viera";
		this.walkingSpeed = 35;
		this.description = "The Viera are lapine people who live in dense forests and act as the protectors of their home. With their more secluded nature, they generally avoid contact with the outside world, happily protecting the Golmore Jungles and Skatay Range, both found in the east. There are two distinct groups of Viera who developed slightly differently based on their homes, the Rava having darker skin while the Veena have far fairer skin, both groups blending into their respective environments better thanks to these adaptations.";
		addBonus(Stat.DEXTERITY,2);
	}

	/**
	 * Assigns the bonus racial stat points
	 */
	protected void raceStats() {
		addBonus(Stat.DEXTERITY, 2);
	}

	/**
	 * {@inheritDoc}
	 */
	public void pickClan(String clan) {
		startingStats();
		initialRaceBonuses.put(Stat.DEXTERITY, 2);
		String clanChoice = clan.toUpperCase().trim();

		if (clanChoice.equals("RAVA") ||clanChoice.equals("1")) {
			this.clanChoice = Viera.VieraClan.RAVA;
		} else if (clanChoice.equals("VEENA") || clanChoice.equals("2")) {
			this.clanChoice =Viera.VieraClan.VEENA;
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
		if (clanChoice == Viera.VieraClan.RAVA) {
			addBonus(Stat.WISDOM, 1);
		} else if (clanChoice == Viera.VieraClan.VEENA) {
			addBonus(Stat.INTELLIGENCE, 1);
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

