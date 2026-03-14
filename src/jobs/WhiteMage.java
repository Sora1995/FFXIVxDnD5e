package jobs;

import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/** Represents the White Mage job and its specific choices */
public class WhiteMage extends Job {
    /** Sets the name and description */
    public WhiteMage() {
        this.name = "White Mage";
        this.description = "A mage who borrows the power of nature to cast spells";

    }
    /**
     * {@inheritDoc}
     */
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() throws IOException {
        this.hitDice = "d6";
        this.baseHP = 6;
        this.savingThrows = "Wisdom, Charisma";
        this.numSpells = 2;
        this.numCantrips = 3;
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("A spellcasting focus (a cane, staff, wand, or similar object");
    }
}

