package jobs;

import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Scholar job and its specific choices */
public class Scholar extends Job {
    /** Sets the name and the description */
    public Scholar() {
        this.name = "Scholar";
        this.description = "A spellcaster who summons a familiar to assist them in battle";

    }
    /**
     * {@inheritDoc}
     */
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() throws IOException {
        this.hitDice = "d6";
        this.baseHP = 6;
        this.savingThrows = "Intelligence, Wisdom";
        this.numCantrips = 3;
        this.numSpells = 2;
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("Dagger");
        addEquipment("A grimoire that acts as spellcasting focus");
    }
}

