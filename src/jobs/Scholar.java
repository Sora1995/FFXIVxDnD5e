package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Scholar extends Job {
    public Scholar() {

    }
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick between the following to add to your starter bag: ", Arrays.asList("Quarterstaff", "Shortsword")));
        ArrayList<String> crossbowOrSimple = new ArrayList<>(getSimpleWeaponsList());
        crossbowOrSimple.add("Light crossbow and 20 bolts");
        equipment.add(new PlayerChoices("Now, pick between the following weapons: ",  crossbowOrSimple));
        equipment.add(new PlayerChoices("Finally, pick between the following packs: ", Arrays.asList("Scholar's Pack", "Explorer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Scholar";
        this.hitDice = "d6";
        this.baseHP = 6;
        this.savingThrows = "Intelligence, Wisdom";
        this.description = "A spellcaster who summons a familiar to assist them in battle";
        addEquipment("Dagger");
        addEquipment("A grimoire that acts as spellcasting focus");
    }
}

