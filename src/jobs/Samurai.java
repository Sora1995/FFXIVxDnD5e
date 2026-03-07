package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Samurai extends Job {
    public Samurai() {
    }

    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> armourOrMartial = new ArrayList<>(getMartialWeaponsList());
        armourOrMartial.add("Chain Shirt");
        armourOrMartial.add("Leather Armour");
        equipment.add(new PlayerChoices("Pick between the following armour to add to your starting bag: ", armourOrMartial));
        equipment.add(new PlayerChoices("Finally, pick between the following packs: ", Arrays.asList("Explorer's Pack", "Dungeoneer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Samurai";
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Strength, Wisdom";
        this.description = "A fighter specializing in an eastern approach to combat";
        addEquipment("Katana");
        addEquipment("Decorative scabbard for your katana");
        addEquipment("Short bow and 20 arrows");
    }
}

