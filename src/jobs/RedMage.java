package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class RedMage extends Job {
    public RedMage() {
    }
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick between the following armour to put in your starting bag: ", Arrays.asList("Leather Armour", "Hide Armour")));
        ArrayList<String> crossbowOrSimple = new ArrayList<>(getSimpleWeaponsList());
        crossbowOrSimple.add("A light crossbow and 20 bolts");
        equipment.add(new PlayerChoices("Now, pick between the following: ", crossbowOrSimple));
        equipment.add(new PlayerChoices("Finally, pick between the following packs: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Red Mage";
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Dexterity, Charisma";
        this.description = "A mage who draws from the schools of white and black magic, weaving them together with swordplay";
        addEquipment("Rapier");
        addEquipment("Spellcasting focus");
    }
}

