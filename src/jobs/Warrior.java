package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Warrior extends Job {
    public Warrior() {
    }
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> martialOrSimple = new ArrayList<>(getMartialWeaponsList());
        martialOrSimple.addAll(getSimpleWeaponsList());
        equipment.add(new PlayerChoices("Please pick between the following weapons to add to your starting bag: ", martialOrSimple));
        ArrayList<String> martialOrSimple2 = new ArrayList<>(getMartialWeaponsList());
        martialOrSimple2.addAll(getSimpleWeaponsList());
        equipment.add(new PlayerChoices("Please pick a second martial or simple weapon: ", martialOrSimple2));
        equipment.add(new PlayerChoices("Now, pick between the following weapons: ", Arrays.asList("Two handaxes", "Light crossbow and 20 bolts")));
        equipment.add(new PlayerChoices("Next, pick between the following packs:" , Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        equipment.add(new PlayerChoices("Finally, pick between the following armour: ", Arrays.asList("Scale Mail", "Leather Armour")));
        return equipment;

    }

    @Override
    public void applyJob() {
        this.name = "Warrior";
        this.hitDice = "d12";
        this.baseHP = 12;
        this.savingThrows = "Strength, Constitution";
        this.description = "A fighter who uses immense strength and bulk to overpower opponents";
        addEquipment("Carved wooden idol related to heritage");
    }
}
