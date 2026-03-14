package main;

import races.Race;
import jobs.Job;

/**
 * This class lays the groundwork for all characters
 * It controls the core of the character, including alignment, sex, race, and name
 */

public class Character {
    /**
     * Represents the available biological sexes for character generation.
     * Used primarily to determine gendered naming conventions (like Garlean titles).
     */
    public enum Sex {
        MALE,
        FEMALE
    }

    private String name;
    private Sex sex;
    private Race race;
    private Job job;

    /**
     * Represents the alignment system and choices a character has
     */
    public enum Alignment {
        LAWFUL_GOOD("Lawful Good"), NEUTRAL_GOOD("Neutral Good"), CHAOTIC_GOOD("Chaotic Good"),
        LAWFUL_NEUTRAL("Lawful Neutral"), TRUE_NEUTRAL("True Neutral"), CHAOTIC_NEUTRAL("Chaotic Neutral"),
        LAWFUL_EVIL("Lawful Evil"), NEUTRAL_EVIL("Neutral Evil"), CHAOTIC_EVIL("Chaotic Evil");

        private final String cleanAlignment;

        Alignment(String cleanAlignment) {
            this.cleanAlignment = cleanAlignment;
    }

        /**
         * {inheritDoc}
         */
        @Override
        public String toString() {
            return this.cleanAlignment;
        }
    }

    /**
     * Empty constructor
     */
    public Character() {
    }

    /**
     * Sets the race of the character being created
     * @param race The race chosen by the player
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     * Gets the races of the character assigned to it
     * @return the race of the character
     */
    public Race getRace() {
        return this.race;
    }

    /**
     * Sets the job chosen by the player
     * @param job The job chosen for the character
     */
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * Sets the sex of the character
     * @param sex The sex chosen by the player
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Sets the name of the character
     * @param name The chosen name of the character
     */
    public void setName(String name) {
        this.name = name;
    }

}
