package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Paladin job and its specific choices */
public class Paladin extends Job {
    /** Sets the name and description */
    public Paladin() {
        this.name = "Sultansworn Paladin";
        this.description = "An armored knight who uses their aether to empower their equipment";

    }
    /**
     * {@inheritDoc}
     */
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
    /**
     * {@inheritDoc}
     */
    @Override
    public void applyJob() {
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Constitution, Charisma";
        addEquipment("A chain shirt and a holy symbol related to your home region");
    }
}

