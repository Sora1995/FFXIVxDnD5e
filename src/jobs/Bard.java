package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/** Represents the Bard job and the specific choices */
public class Bard extends Job {
/**Sets the name and description */
	public Bard() {
		this.name = "Gridanian Bard";
		this.description = "A ranged specialist who balances martial and magical abilities with song.";

	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<PlayerChoices> addJobOptions() {
		ArrayList<PlayerChoices> equipment = new ArrayList<>();
		PlayerChoices branchingWeaponPath = new PlayerChoices(
				"Bards get the option of a Rapier or two martial weapons. Please pick which you'd like:",
				Arrays.asList("Rapier", "Two martial weapons"),
				false
		);
		ArrayList<String> bardMartialList = getMartialWeaponsList();
		bardMartialList.remove("Rapier");
		PlayerChoices rapierOrMartial1 = new PlayerChoices("Choose your first martial weapon:", bardMartialList);
		PlayerChoices rapierOrMartial2 = new PlayerChoices("Choose your second martial weapon:", bardMartialList);
		for (String weapon : bardMartialList) {
			rapierOrMartial1.fQuestion(weapon, rapierOrMartial2);
		}
		branchingWeaponPath.fQuestion("Two martial weapons", rapierOrMartial1);
		PlayerChoices rapierOrMartial3 = new PlayerChoices("Adding Rapier to starting bag", Arrays.asList("Rapier"));
		branchingWeaponPath.fQuestion("Rapier", rapierOrMartial3);

		equipment.add(branchingWeaponPath);

		equipment.add(new PlayerChoices("Pick between the following packs: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));
		equipment.add(new PlayerChoices("Finally, select one of the following instruments: ", getMusicalInstrumentsList()));

		return equipment;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyJob() {
		this.hitDice = "1d8";
		this.baseHP = 8;
		this.savingThrows = "Dexterity, Charisma";
		addEquipment("Longbow and quiver of 20 arrows");
		addEquipment("Leather armor");
	}
}
