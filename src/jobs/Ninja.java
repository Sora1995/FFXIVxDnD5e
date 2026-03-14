package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Ninja job and its specific choices */
public class Ninja extends Job {
    /** Sets the name and description */
    public Ninja() {
        this.name = "Ninja";
        this.description = "A fighter who uses deception and speed with a large variety of tools.";

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();

        equipment.add(getValidSimpleWeaponChoice());

        equipment.add(new PlayerChoices("Please pick between the following packs: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        return equipment;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() {
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Dexterity, Intelligence";
        addEquipment("Two daggers");
        addEquipment("Shortbow and 20 arrows");
        addEquipment("Leather Armour");
        addEquipment("Thieves' Tools");
    }
}

