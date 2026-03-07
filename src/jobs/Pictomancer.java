package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Pictomancer extends Job {
    public Pictomancer() {
    }

    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Pick between the following packs to add to your starting bag: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Pictomancer";
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Wisdom, Charisma";
        this.description = "A mage who uses magic to make their imagination reality";
        addEquipment("Dagger");
        addEquipment("Light crossbow and 20 bolts");
        addEquipment("A brush based spell casting focus (a cane, staff, wand, or similar object");
        addEquipment("Painter's supplies");
    }
}

