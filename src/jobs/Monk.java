package jobs;

import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Monk job and its specific choices */
public class Monk extends Job {
    /** Sets the name and description */
    public Monk() {
        this.name = "Eorzean Monk";
        this.description = "A fighter that specializes in unarmed combat wielding elemental power";

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> shortSwordOrMartial = new ArrayList<>(getMartialWeaponsList());
        shortSwordOrMartial.add("Shortsword");
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag", shortSwordOrMartial));
        equipment.add(new PlayerChoices("Finally, pick a pack toa dd to your starting bag: ", Arrays.asList("Dungeoneer's Pack", "Explorer's Pack")));
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
        addEquipment("10 darts");
    }
}

