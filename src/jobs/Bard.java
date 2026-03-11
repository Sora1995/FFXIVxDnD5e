package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bard extends Job {

	public Bard() {
	}

	@Override
	public ArrayList<PlayerChoices> addJobOptions() {
		Scanner scan = new Scanner(System.in);
		ArrayList<PlayerChoices> equipment = new ArrayList<>();
		ArrayList<String> instrument = new ArrayList<>(getMusicalInstrumentsList());
		System.out.println(
				"Bards get the option of a Rapier or two martial weapons. Please pick which you'd like:\n(1) Rapier(2) Two martial weapons");
		String input = scan.nextLine().trim();
		if (input.equals("1") || input.equals("Rapier")) {
			addEquipment("Rapier");
			System.out.println("Rapier has been added to your starter bag");
		} else {
			ArrayList<String> rapierOrMartial = getMartialWeaponsList();
			boolean validChoice1 = false;
			int martialWeapon1Index = -1;
			while (!validChoice1) {
				System.out.println("Choose your first martial weapon\n");
				for (int i = 0; i < rapierOrMartial.size(); i++) {
					System.out.println((i + 1) + ". " + rapierOrMartial.get(i));
				}
				String weaponSelection = scan.nextLine().trim();
				try {
					int choice = Integer.parseInt(weaponSelection);
					if (choice < 1 || choice > rapierOrMartial.size()) {
						System.out.println("Please type a number between 1 and " + rapierOrMartial.size());
					} else {
						validChoice1 = true;
						martialWeapon1Index = choice - 1;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please type a number");
				}
			}
			addEquipment(rapierOrMartial.get(martialWeapon1Index));
			boolean validChoice2 = false;
			int martialWeapon2Index = -1;
			while (!validChoice2) {
				System.out.println("Choose your second martial weapon\n");
				for (int i = 0; i < rapierOrMartial.size(); i++) {
					System.out.println((i + 1) + ". " + rapierOrMartial.get(i));
				}
				String weaponSelection = scan.nextLine().trim();
				try {
					int choice = Integer.parseInt(weaponSelection);
					if (choice < 1 || choice > rapierOrMartial.size()) {
						System.out.println("Please type a number between 1 and " + rapierOrMartial.size());
					} else {
						validChoice2 = true;
						martialWeapon2Index = choice - 1;
					}
				} catch (NumberFormatException e) {
					System.out.println("Please type a number");
				}
			}
			addEquipment(rapierOrMartial.get(martialWeapon2Index));
		}
		equipment.add(new PlayerChoices("Pick between the following packs: ",
				Arrays.asList("Explorer's Pack", "Scholar's Pack")));
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
