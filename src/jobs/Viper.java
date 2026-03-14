package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Viper job and its specific choices */
public class Viper extends Job {
    /** Sets the name and description */
    public Viper() {
        this.name = "Viper";
        this.description = "A fighter who uses dual wielding to overwhelm their foes with flurries of strikes";

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Pick between the following packs to add to your starting bag: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        return equipment;

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() {
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Strength, Dexterity";
        addEquipment("Two shortswords");
        addEquipment("Short bow and 20 arrows");
        addEquipment("Leather Armour");
    }
}
