package jobs;

import main.PlayerChoices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Summoner job and its specific choices */
public class Summoner extends Job {
    /** Sets the name and description */
    public Summoner() {
        this.name = "Summoner";
        this.description = "A spellcaster who summons an elemental egi to assist them in battle";

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick between the following to add to your starting bag: ", Arrays.asList("Quarterstaff", "Shortsword")));
        ArrayList<String> crossbowOrSimple = new ArrayList<>(getSimpleWeaponsList());
        crossbowOrSimple.add("Light crossbow and 20 bolts");
        equipment.add(new PlayerChoices("Now, pick between the following weapons: ", crossbowOrSimple));
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
        this.savingThrows = "Wisdom, Charisma";
        this.numCantrips = 4;
        this.numSpells = 4;
        this.spellSlots[1] = 2;
        startingSpells();
        this.knownCantrips = pickRandomSpell(this.knownCantrips, this.numCantrips);
        this.firstLevelSpells = pickRandomSpell(this.firstLevelSpells, this.numSpells);
        addEquipment("Grimoire that acts as spell casting focus");
    }
}
