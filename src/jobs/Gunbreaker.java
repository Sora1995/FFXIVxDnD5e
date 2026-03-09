package jobs;
import main.PlayerChoices;

import java.util.ArrayList;
import java.util.Arrays;

public class Gunbreaker extends Job {
    public Gunbreaker() {
    }

    @Override
public ArrayList<PlayerChoices> addJobOptions() {
        ArrayList<PlayerChoices> equipment = new ArrayList<>();
        equipment.add(new PlayerChoices("Pick a martial weapon that has been converted to a gunblade: ", getMartialWeaponsList()));
        equipment.add(new PlayerChoices("Pick from one of the following to add to your starter bag: ", Arrays.asList("Scale Mail", "Leather Armour")));
        equipment.add(new PlayerChoices("Now, pick between the following: ", Arrays.asList("A shield", "A pistol and 20 bullets")));
        equipment.add(new PlayerChoices("Finally, pick a pack to start with: ", Arrays.asList("Explorer's Pack", "Dungeoneer's Pack")));
        return equipment;
}

    @Override
    public void applyJob() {
        this.name = "Gunbreaker";
        this.hitDice = "d10";
        this.baseHP = 10;
        this.savingThrows = "Strength, Dexterity";
        this.description = "A bodyguard who augments their weaponry with manatriggers to deliver powerful attacks";
        addEquipment("Smith's tools");
    }
}


