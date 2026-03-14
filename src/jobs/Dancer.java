package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Dancer job and its specific choices */
public class Dancer extends Job {
    /**Sets the name and description */
    public Dancer() {
        this.name = "Dancer";
        this.description = "A supportive fighter who uses both magic and martial arts to control the battlefield";
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {

        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add( new PlayerChoices("Please pick from one of the following to add to your starting bag: ", Arrays.asList("Two daggers", "Two chakrams")));
        equipment.add(new PlayerChoices("\"Select from the following to add to your bag:", Arrays.asList("Whip", "Scimitar")));
        equipment.add(new PlayerChoices("Now, select from the following armor choices: ", Arrays.asList("Costume", "Light Armour")));
        equipment.add(new PlayerChoices("Finally, select a pack to start with: ", Arrays.asList("Explorer's Pack", "Entertainer's Pack")));
        return equipment;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() {

        this.hitDice = "1d8";
        this.baseHP = 8;
        this.savingThrows = "Dexterity, Charisma";

        addEquipment("A set of bracelets and anklets for spell casting");
        addEquipment("Clothes");
    }
}
