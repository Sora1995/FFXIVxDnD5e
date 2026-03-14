package jobs;

import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Sage job and its specific choices */
public class Sage extends Job {
    /** Sets the name and description */
    public Sage() {
        this.name = "Sage";
        this.description = "A mage who uses advanced techniques to augment their spell casting";

    }
    /**
     * {@inheritDoc}
     */
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() throws IOException {
        this.spellSlots[1] = 2;
        this.hitDice = "d6";
        this.baseHP = 6;
        this.savingThrows = "Intelligence, Wisdom";
        this.numCantrips = 3;
        this.numSpells = 2;
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("A set of four nouliths and an anchor stone");
    }
}

