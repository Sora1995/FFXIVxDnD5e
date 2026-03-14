package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;
/** Represents the Dark Knight job and its specific choices */
public class DarkKnight extends Job {
    /** Sets the name and description */
    public DarkKnight() {
        this.name = "Dark Knight";
        this.description = "A knight who harnesses forbidden powers to protect the weak";

    }
/**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Please pick from one of the following to add to your starting bag: ", Arrays.asList("Chain Mail", "Hide Armour")));
        ArrayList<String> martialAndShieldOrTwoMartial = new ArrayList<>(getMartialWeaponsList());
        equipment.add(new PlayerChoices("Choose your first martial weapon", martialAndShieldOrTwoMartial));
        ArrayList<String> martialAndShieldOrTwoMartial2 = new ArrayList<>();
        martialAndShieldOrTwoMartial2.add("Shield");
        martialAndShieldOrTwoMartial2.addAll(getMartialWeaponsList());
        equipment.add(new PlayerChoices("Choose a shield or a second martial weapon" , martialAndShieldOrTwoMartial2));
        equipment.add(new PlayerChoices("Select between the following: ", Arrays.asList("Short bow and 20 arrows", "Two daggers")));
        equipment.add(new PlayerChoices("Finally, select a pack: ", Arrays.asList("Explorer's Pack", "Dungeoneer's pack")));
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
    }
}
