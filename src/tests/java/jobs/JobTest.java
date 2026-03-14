package tests.java.jobs;
import static org.junit.jupiter.api.Assertions.*;

import jobs.Warrior;
import org.junit.jupiter.api.Test;

class JobTest {

    @Test
    public void testWarrrior() {
        Warrior warrior = new Warrior();
        warrior.applyJob();
        int conModifier = 3;

        int totalHP = warrior.getHP(conModifier);

        assertEquals(15, totalHP, " Warrior should have 15 HP total (12 base and 3 con)");
    }

    @Test
    public void testNegativeWarriorHP() {
        Warrior warrior = new Warrior();
        warrior.applyJob();
        int conModifier = -1;

        int totalHP = warrior.getHP(conModifier);

        assertEquals(11, totalHP, "Warrior should have 11 HP total (12 base and -1 con");
    }

    @Test
    public void testWarriorZeroHP() {
        Warrior warrior = new Warrior();
        warrior.applyJob();
        int conModifier = 0;
        int totalHP = warrior.getHP(conModifier);
        assertEquals(12, totalHP, "Warrior should have 12 HP total");
    }

    @Test
    public void testWarriorNegativeCon() {
        Warrior warrior = new Warrior();
        warrior.applyJob();
        int conModifier = -15;
        int totalHP = warrior.getHP(conModifier);
        assertEquals(1, totalHP, "Warrior should have 1 HP total");
    }
}