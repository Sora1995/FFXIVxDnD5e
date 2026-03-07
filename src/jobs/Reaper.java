package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Reaper extends Job {
    public Reaper() {
    }
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

    @Override
    public void applyJob() {
        this.name = "Reaper";
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Strength, Wisdom";
        this.description = "A fighter who calls on an ally from the void to aide them in battle.";
        addEquipment("A Momento bestowed to the reaper by the voidsent");
    }
}

