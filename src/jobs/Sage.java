package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Sage extends Job {
    public Sage() {

    }
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick between the following to put in your starting bag: ", Arrays.asList("Quarterstaff", "Dagger")));
        ArrayList<String> crossbowOrSimple = new ArrayList<>(getSimpleWeaponsList());
        crossbowOrSimple.add("A light crossbow and 20 bolts");
        equipment.add(new PlayerChoices("Next, pick between the following weapons: ", crossbowOrSimple));
        equipment.add(new PlayerChoices("Now, pick between the following: ", Arrays.asList("Component Pouch", "Arcane Focus")));
        equipment.add(new PlayerChoices("Finally, pick between the following packs: ", Arrays.asList("Scholar's Pack", "Explorer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Save";
        this.hitDice = "d6";
        this.baseHP = 6;
        this.savingThrows = "Intelligence, Wisdom";
        this.description = "A mage who uses advanced techniques to augment their spell casting";
        addEquipment("A set of four nouliths and an anchor stone");
    }
}

