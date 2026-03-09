package jobs;
import main.PlayerChoices;

import java.util.*;

public abstract class Job {
    protected String name;
    protected String description;

    protected String hitDice;
    protected int baseHP;
    protected String savingThrows;

    protected ArrayList<String> proficiencies;
    protected ArrayList<String> startingEquipment;
    
    protected ArrayList<String> knownCantrips;
    
    protected int[] spellSlots;


    protected ArrayList<String> getMartialWeaponsList() {
        return new ArrayList<>(Arrays.asList("Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halberd", "Lance", "Longsword", "Maul", "Morningstar", "Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War Pick", "Warhammer", "Whip"));
    }

    protected PlayerChoices getValidMartialWeaponChoice() {
        return new PlayerChoices("Pick from the following martial weapons: ", getMartialWeaponsList());
    }

    protected ArrayList<String> getSimpleWeaponsList() {
        return new ArrayList<>(Arrays.asList("Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear", "Light Crossbow", "Dart", "Shortbow", "Sling"));
    }

    protected PlayerChoices getValidSimpleWeaponChoice() {
        return new PlayerChoices("Choose one of the following simple weapons: ", getSimpleWeaponsList());
    }

    protected ArrayList<String> getArtisanToolsList() {
        return new ArrayList<>(Arrays.asList("Alchemist's supplies", "Brewer's supplies", "Calligrapher's supplies", "Carpenter's tools", "Cartographer's tools", "Cobbler's tools", "Cook's utensils", "Glassblower's tools", "Jeweler's tools", "Leatherworker's tools", "Mason's tools", "Painter's supplies", "Potter's tools", "Smith's tools", "Tinker's tools", "Weaver's tools", "Woodcarver's tools"));
    }

    protected PlayerChoices getValidArtisanTools() {
        return new PlayerChoices("You get a set of artisan's tools of your choice. Please pick from the following: ", getArtisanToolsList());
    }
    protected ArrayList<String> getMusicalInstrumentsList() {
        return new ArrayList<>(Arrays.asList("Bagpipes", "Drum", "Dulcimer", "Flute", "Lute", "Lyre", "Horn", "Pan flute", "Shawm", "Viol"));
    }

    public Job() {
        this.proficiencies = new ArrayList<>();
        this.startingEquipment = new ArrayList<>();
        this.knownCantrips = new ArrayList<>();
        this.spellSlots = new int[10];
    }
    
    public void addCantrip(String cantrip) {
		knownCantrips.add(cantrip);
	}
	
	public int getSpellSlotsForEachLevel(int spellLevel) {
		if (spellLevel > 0 && spellLevel <= 9) {
			return spellSlots[spellLevel];
		}
		return 0;
	}

    public String getJobName() {
        return name;
    }
    public int getHP(int conModifier) {
        return baseHP + conModifier;
    }
    
    public abstract ArrayList<PlayerChoices> addJobOptions();
    
    public void addEquipment(String item) {
        startingEquipment.add(item);
    }

    public abstract void applyJob();

    public void printInventory() {
        System.out.println("Inventory: " + startingEquipment);
    }
    public String getSavingThrows() {
        return savingThrows;
    }
}
