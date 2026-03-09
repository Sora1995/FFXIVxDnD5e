package main;

import races.Race;
import jobs.Job;

import java.util.*;

public class Character {
    public enum Sex {
        MALE,
        FEMALE
    }

    private String name;
    private Sex sex;
    private Race race;
    private Job job;

    public enum Alignment {
        LAWFUL_GOOD, NEUTRAL_GOOD, CHAOTIC_GOOD,
        LAWFUL_NEUTRAL, TRUE_NEUTRAL, CHAOTIC_NEUTRAL,
        LAWFUL_EVIL, NEUTRAL_EVIL, CHAOTIC_EVIL
    }

    private Alignment alignment;

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public Character() {
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return this.race;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

}
