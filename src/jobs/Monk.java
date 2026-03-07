package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Monk extends Job {
    public Monk() {
    }

    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> shortSwordOrMartial = new ArrayList<>(getMartialWeaponsList());
        shortSwordOrMartial.add("Shortsword");
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag", shortSwordOrMartial));
        equipment.add(new PlayerChoices("Finally, pick a pack toa dd to your starting bag: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
        return equipment;
    }

    @Override
    public void applyJob() {
        this.name = "Eorzean Monk";
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Strength, Dexterity";
        this.description = "A fighter that specializes in unarmed combat wielding elemental power";
        addEquipment("10 darts");
    }
}

