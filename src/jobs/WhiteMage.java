package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class WhiteMage extends Job {
    public WhiteMage() {
    }
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Pick between the following weapons to add to your starting bag: ", Arrays.asList("Dagger", "Quarterstaff")));
        ArrayList<String> crossbowOrSimple = new ArrayList<>(getSimpleWeaponsList());
        crossbowOrSimple.add("Light crossbow and 20 bolts");
        equipment.add(new PlayerChoices("Now, pick between the following weapons: ", crossbowOrSimple));
        equipment.add(new PlayerChoices("Finally, pick between the following packs: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));
        return equipment;

    }

    @Override
    public void applyJob() {
        this.name = "White Mage";
        this.hitDice = "d6";
        this.baseHP = 6;
        this.savingThrows = "Wisdom, Charisma";
        this.description = "A mage who borrows the power of nature to cast spells";
        addEquipment("A spellcasting focus (a cane, staff, wand, or similar object");
    }
}

