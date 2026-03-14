package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Machinist class and its specific choices */
public class Machinist extends Job {
    /** Sets the name and description */
    public Machinist() {
        this.name = "Machinist";
        this.description = "A tinkerer who uses firearms and creates many devices and clockwork companions to do battle";
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag: ",
                Arrays.asList("A pistol and 20 bullets", "A dagger")));
        equipment.add(new PlayerChoices("Next, pick a pack to add to your starting bag: ",
                Arrays.asList("Explorer's Pack", "Dungeoneer's Pack")));
        equipment.add(new PlayerChoices("Finally, pick an artisan toolkit: ", getArtisanToolsList()));
        return equipment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() {
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Dexterity, Intelligence";
        addEquipment("Leather armour");
        addEquipment("Aetherconverter");
        addEquipment("A musket and 20 bullets");
    }
}
