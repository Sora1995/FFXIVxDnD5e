package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Paladin extends Job {
    public Paladin() {
    }

    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> martialAndShieldOrTwoMartial = new ArrayList<>();
        equipment.add(new PlayerChoices("Choose your first martial weapon", martialAndShieldOrTwoMartial));
        ArrayList<String> martialAndShieldOrTwoMartial2 = new ArrayList<>();
        martialAndShieldOrTwoMartial2.add("Shield");
        martialAndShieldOrTwoMartial2.addAll(getMartialWeaponsList());
        equipment.add(new PlayerChoices("Choose a shield or a second martial weapon", martialAndShieldOrTwoMartial2));
        ArrayList<String> javelinOrSimple = new ArrayList<>(getSimpleWeaponsList());
        javelinOrSimple.add("Five javelins");
        equipment.add(new PlayerChoices("Now, pick from the following: ", javelinOrSimple));
        equipment.add(new PlayerChoices("Finally, pick which pack you want to add to your starting bag: ", Arrays.asList("Explorer's Pack", "Dungeoneer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Sultansworn Paladin";
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Constitution, Charisma";
        this.description = "An armored knight who uses their aether to empower their equipment";
        addEquipment("A chain shirt and a holy symbol related to your home region");
    }
}

