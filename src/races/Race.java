package races;

import main.Character;
import main.PlayerChoices;

import java.util.*;

/**
 * Lays the groundwork for every race, including name, stats, and a description of each race
 */
public abstract class Race {
    protected String name;
    protected String description;
    protected int walkingSpeed;
    protected Map<Stat,Integer> statBonuses;
    protected Map<Stat,Integer> initialRaceBonuses =  new HashMap<>();
    protected int darkVisionRadius; // 0 if no dark vision, otherwise the range in feet

    /**
     * Generates a name randomly, utilizing the sex of the character for everyone, and utilizing stats for Garleans
     * @param sex The sex of the character being created
     * @param stats The stats assigned to the character, used in assigning a Garlean title
     * @return A randomly generated string representing a race-appropriate name
     */
    public abstract String randomNameGenerator(Character.Sex sex, HashMap<String, Integer> stats);

    /**
     * Gets the radius of darkvision of the character
     * @return the darkvision radius
     */
    public int getDarkVisionRadius() {
        return darkVisionRadius;
    }

    /**
     * Represents each stat the character has
     */
        public enum Stat {
		STRENGTH,
		DEXTERITY,
		CONSTITUTION,
		INTELLIGENCE,
		WISDOM,
		CHARISMA
	}



    /**
     * Constructor for Race. Creates a HashMap for stat bonuses, where starting stats go
     */
    public Race() {
        this.statBonuses = new HashMap<>();
        startingStats();
    }

    /**
     * Method to assign starting stats
     */
	protected void startingStats() {
		for (Stat s : Stat.values()) {
			statBonuses.put(s,0);
		}
	}

    /**
     *Gets the name of the character being created
     * @return the name of the character
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the character being created
     * @return the description of the character
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the walking speed of the character
     * @return the walking speed of the character
     */
    public int getWalkingSpeed() {
        return walkingSpeed;
    }

    /**
     * Gets the bonuses for stats that are assigned by race and job
     * @param statName The name of the stat having a bonus added
     * @return The numerical bonus being applied to a stat, or 0 if not assigning one
     */
    public int getBonusFor(Stat statName) {
        return this.statBonuses.getOrDefault(statName, 0);
    }

    /**
     * Used to pick a clan, and accepts the race-specific clans as parameter
     * @param clan The specific clan for the assigned race
     */
    public abstract void pickClan(String clan);

    /**
     * The bonus each clan provides, such as increased Intelligence, Strength, or Dexterity
     */
    public abstract void clanBonuses();

    /**
     * The ArrayList of races for the user to pick from
     * @return the races
     */
    public abstract ArrayList<PlayerChoices> raceOptions();

    /**
     * Used when generating a Hyur, allowing the user to pick a stat to assign a bonus to
     * @param input The stat the user selects
     */
    public abstract void chosenVariables(String input);

    /**
     * Adds the bonuses to the specified stats
     * @param stat The stat that the bonus is being applied to
     * @param quantity The amount being applied as a bonus (+1, +2, etc.)
     */
    protected void addBonus(Stat stat, int quantity) {
        if (statBonuses.containsKey(stat)) {
            statBonuses.compute(stat, (k, currentBonus) -> currentBonus + quantity);
        }
    }
}
