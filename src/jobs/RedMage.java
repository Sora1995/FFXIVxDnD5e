package jobs;
import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Red Mage job and its specific choices */
public class RedMage extends Job {
    /** Sets the name and description */
    public RedMage() {
        this.name = "Red Mage";
        this.description = "A mage who draws from the schools of white and black magic, weaving them together with swordplay";

    }
    /**
     * {@inheritDoc}
     */
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() throws IOException {
        this.spellSlots[1] = 2;
        this.numCantrips = 4;
        this.numSpells = 2;
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Dexterity, Charisma";
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("Rapier");
        addEquipment("Spellcasting focus");
    }
}

