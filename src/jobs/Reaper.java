package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Reaper job and its specific choices */
public class Reaper extends Job {
    /** Sets the name and description */
    public Reaper() {
        this.name = "Reaper";
        this.description = "A fighter who calls on an ally from the void to aide them in battle.";

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> scytheOrMartial = new ArrayList<>(getMartialWeaponsList());
        scytheOrMartial.add("Battle Scythe");
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag: ", scytheOrMartial));
        equipment.add(new PlayerChoices("Now, pick between the following: ", Arrays.asList("Two handaxes", "A light crossbow with 20 bolts")));
        equipment.add(new PlayerChoices("Next, pick between the following armour:", Arrays.asList("Scale Mail", "Leather Armour")));
        equipment.add(new PlayerChoices("Finally, pick between the following packs: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        return equipment;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() {
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Strength, Wisdom";
        addEquipment("A Momento bestowed to the reaper by the voidsent");
    }
}

