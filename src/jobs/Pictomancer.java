package jobs;

import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Pictomancer job and its specific choices */
public class Pictomancer extends Job {
    /** Sets the name and description */
    public Pictomancer() {
        this.name = "Pictomancer";
        this.description = "A mage who uses magic to make their imagination reality";


    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Pick between the following packs to add to your starting bag: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));
        return equipment;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() throws IOException {
        this.spellSlots[1] = 2;
        this.numCantrips = 3;
        this.numSpells = 4;
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Wisdom, Charisma";
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("Dagger");
        addEquipment("Light crossbow and 20 bolts");
        addEquipment("A brush based spell casting focus (a cane, staff, wand, or similar object");
        addEquipment("Painter's supplies");
    }
}

