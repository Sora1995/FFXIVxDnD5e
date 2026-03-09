package races;

import main.PlayerChoices;

import java.util.*;

public abstract class Race extends main.Character {
    protected String name;
    protected String description;
    protected int walkingSpeed;

    protected int darkVisionRadius; // 0 if no dark vision, otherwise the range in feet

    public abstract String randomNameGenerator(Sex sex, HashMap<String, Integer> stats);

    public abstract void printClanMenu();

    public boolean hasDarkVision() {
        return darkVisionRadius > 0;
    }
    public int getDarkVisionRadius() {
        return darkVisionRadius;
    }
        public enum Stat {
		STRENGTH,
		DEXTERITY,
		CONSTITUTION,
		INTELLIGENCE,
		WISDOM,
		CHARISMA
	}

    protected Map<Stat,Integer> statBonuses;
    protected Map<Stat,Integer> initialRaceBonuses =  new HashMap<>();
    
    public Race() {
        this.statBonuses = new HashMap<>();
        startingStats();
    }
    
	protected void startingStats() {
		for (Stat s : Stat.values()) {
			statBonuses.put(s,0);
		}
	}


    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getWalkingSpeed() {
        return walkingSpeed;
    }

    public int getBonusFor(Stat statName) {
        return this.statBonuses.getOrDefault(statName, 0);
    }

    public  abstract  void  pickClan(String clan);

    public abstract void clanBonuses();

    public abstract ArrayList<PlayerChoices> raceOptions();

    public abstract void chosenVariables(String input);

    protected void addBonus(Stat stat, int quantity) {
        if (statBonuses.containsKey(stat)) {
            statBonuses.compute(stat, (k, currentBonus) -> currentBonus + quantity);
        }
    }
}
