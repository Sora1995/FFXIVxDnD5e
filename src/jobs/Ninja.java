package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Ninja extends Job {
    public Ninja() {}

    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();

        equipment.add(getValidSimpleWeaponChoice());

        equipment.add(new PlayerChoices("Please pick between the following packs: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Ninja";
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Dexterity, Intelligence";
        this.description = "A fighter who uses deception and speed with a large variety of tools.";
        addEquipment("Two daggers");
        addEquipment("Shortbow and 20 arrows");
        addEquipment("Leather Armour");
        addEquipment("Thieves' Tools");
    }
}

