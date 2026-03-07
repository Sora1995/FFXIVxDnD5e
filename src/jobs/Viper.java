package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Viper extends Job {
    public Viper() {

    }
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Pick between the following packs to add to your starting bag: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        return equipment;

    }

    @Override
    public void applyJob() {
        this.name = "Viper";
        this.hitDice = "d8";
        this.baseHP = 8;
        this.savingThrows = "Strength, Dexterity";
        this.description = "A fighter who uses dual wielding to overwhelm their foes with flurries of strikes";
        addEquipment("Two shortswords");
        addEquipment("Short bow and 20 arrows");
        addEquipment("Leather Armour");
    }
}
