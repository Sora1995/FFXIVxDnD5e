package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Bard extends Job{

	public Bard() {
	}

	@Override
	public ArrayList<PlayerChoices> addJobOptions() {
		ArrayList<PlayerChoices> equipment = new ArrayList<>();
		ArrayList<String> instrument = new ArrayList<>(getMusicalInstrumentsList());
		ArrayList<String> rapierOrMartial = new ArrayList<>();
		rapierOrMartial.add("Rapier");
		rapierOrMartial.addAll(getMartialWeaponsList());
		equipment.add(new PlayerChoices("Choose between the following: ", rapierOrMartial));
		ArrayList<String> rapierOrMartial2 = new ArrayList<>();
		rapierOrMartial2.add("None, I chose the rapier");
		rapierOrMartial2.addAll(getMartialWeaponsList());
		equipment.add(new PlayerChoices("Choose between the following: ", rapierOrMartial2));
		equipment.add(new PlayerChoices("Pick between the following packs: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));
		equipment.add(new PlayerChoices("Finally, select one of the following instruments: ", instrument));

		return equipment;
	}

	@Override
	public void applyJob() {
		this.name = "Gridanian Bard";
		this.hitDice = "1d8";
		this.baseHP = 8;
		this.savingThrows = "Dexterity, Charisma";
		this.description = "A ranged specialist who balances martial and magical abilities with song.";
		addEquipment("Longbow and quiver of 20 arrows");
		addEquipment("Leather armor");
	}
}
