package jobs;

import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents the Astrologian job and its specific choices
 */
public class Astrologian extends Job {
    /**Sets the name and description */
    public Astrologian() {
        this.name = "Astrologian";
        this.description = "A spellcaster who combines fortune telling and astrology in battle.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() throws IOException {
        this.hitDice = "1d8";
        this.baseHP = 8;
        this.savingThrows = "Wisdom, Charisma";
        this.spellSlots[1] = 2;//how many spell slots they have at level 1
        this.numCantrips = 3;//how many cantrips they know
        this.numSpells = 2; //how many spells they know
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("Star Globe");
        addEquipment("Divination Deck");
    }

    /**
     * {@inheritDoc}
     */
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
}

