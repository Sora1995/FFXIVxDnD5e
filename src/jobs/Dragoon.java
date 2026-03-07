package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Dragoon extends Job {
    public Dragoon() {
    }

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

    @Override
    public void applyJob() {
        this.name = "Dragoon";
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Strength, Dexterity";
        this.description = "A high flying warrior who specializes in fighting and utilizes the power of dragons";
        addEquipment("Blessed Dragoon's stone");
    }
}

