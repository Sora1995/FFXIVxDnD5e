package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Astrologian extends Job {
    public Astrologian() {}
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> astroOptions = new ArrayList<>();
        astroOptions.add("Light Crossbow with 20 bolts");
        astroOptions.addAll(getSimpleWeaponsList());

        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag: ", Arrays.asList("Dagger", "Quarter Staff")));
        equipment.add(new PlayerChoices("Select from the following to add to your bag: ", astroOptions));
        equipment.add(new PlayerChoices("Finally, select a pack to start with: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));

        return equipment;

    }
    @Override
    public void applyJob() {
        this.name = "Astrologian";
        this.hitDice = "1d8";
        this.baseHP = 8;
        this.savingThrows = "Wisdom, Charisma";
        this.description = "A spellcaster who combines fortune telling and astrology in battle.";
        addEquipment("Star Globe");
        addEquipment("Divination Deck");
    }
}

