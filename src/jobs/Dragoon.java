package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Dragoon class and its specific choices */
public class Dragoon extends Job {
    /** Sets the name and the description */
    public Dragoon() {
        this.name = "Dragoon";
        this.description = "A high flying warrior who specializes in fighting and utilizes the power of dragons";

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag: ", Arrays.asList("Scale Mail", "Leather Armour")));
        ArrayList<String> martialOrSpears = new ArrayList<>(getMartialWeaponsList());
        martialOrSpears.add("Two spears");
        equipment.add(new PlayerChoices("Now, select between the following: ", martialOrSpears));
        equipment.add(new PlayerChoices("Next, select from: ", Arrays.asList("Short bow and 20 arrows", "Two hand axes")));
        equipment.add(new PlayerChoices("Finally, select a pack to start with: ", Arrays.asList("Explorer's Pack", "Dungeoneer's Pack")));
        return equipment;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() {
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Strength, Dexterity";
        addEquipment("Blessed Dragoon's stone");
    }
}

