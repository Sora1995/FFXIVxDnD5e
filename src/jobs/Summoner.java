package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Summoner extends Job {
    public Summoner() {

    }

    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick between the following to add to your starting bag: ", Arrays.asList("Quarterstaff", "Shortsword")));
        ArrayList<String> crossbowOrSimple = new ArrayList<>(getSimpleWeaponsList());
        crossbowOrSimple.add("Light crossbow and 20 bolts");
        equipment.add(new PlayerChoices("Now, pick between the following weapons: ", crossbowOrSimple));
        equipment.add(new PlayerChoices("Finally, pick between the following packs: ", Arrays.asList("Scholar's Pack", "Explorer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Summoner";
        this.hitDice = "d6";
        this.baseHP = 6;
        this.savingThrows = "Wisdom, Charisma";
        this.description = "A spellcaster who summons an elemental egi to assist them in battle";
        addEquipment("Grimoire that acts as spell casting focus");
    }
}
