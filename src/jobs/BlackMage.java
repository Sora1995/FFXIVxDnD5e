package jobs;
import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Black Mage job and its specific choices  */
public class BlackMage extends Job {
    /**Sets the name and description */
    public BlackMage() {
        this.name = "Black Mage";
        this.description = "A mage who calls upon the power of the void to empower their spells.";

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> bowOrSimple = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag: ", Arrays.asList("Dagger", "Quarter Staff")));
        bowOrSimple.add("Light crossbow with 20 bolts");
        bowOrSimple.addAll(getSimpleWeaponsList());
        equipment.add(new PlayerChoices("Select from the following to add to your bag: ", bowOrSimple));
        equipment.add(new PlayerChoices("Finally, select a pack to start with: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));

        return equipment;
    }
/**
 * {@inheritDoc}
 */
    @Override
    public void applyJob() throws IOException {
        this.spellSlots[1] = 2;
        this.numCantrips = 3;
        this.numSpells = 2;
        this.hitDice = "1d6";
        this.baseHP = 6;
        this.savingThrows = "Intelligence, Wisdom";
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("Spellbook");
        addEquipment("Casting Focus of your choice");
    }
}
