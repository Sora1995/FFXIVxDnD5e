package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackMage extends Job {
    public BlackMage() {
    }
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        ArrayList<String> bowOrSimple = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag: ", Arrays.asList("Dagger", "Quarter Staff")));
        bowOrSimple.add("Light crossbow with 20 bolts");
        bowOrSimple.addAll(getSimpleWeaponsList());
        equipment.add(new PlayerChoices("Select from the following to add to your bag: ", bowOrSimple));
        equipment.add(new PlayerChoices("Finally, select a pack to start with: ", Arrays.asList("Explorer's Pack", "Scholar's Pack")));

        return equipment;
    }

    @Override
    public void applyJob() {

        this.name = "Black Mage";
        this.hitDice = "1d6";
        this.baseHP = 6;
        this.savingThrows = "Intelligence, Wisdom";
        this.description = "A mage who calls upon the power of the void to empower their spells.";

        addEquipment("Spellbook");
        addEquipment("Casting Focus of your choice");
    }
}
