package tests.java.races;

import main.Character;
import org.junit.jupiter.api.Test;
import races.Garlean;
import races.Race;
import races.Viera;

import java.util.HashMap;
import main.Character.Sex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {

    @Test
    public void testVieraVeena_StatBonuses() {
        Viera v = new Viera();
        v.pickClan("Veena");
        assertEquals(2, v.getBonusFor(Race.Stat.DEXTERITY), "Viera should have +2 Dexterity");
        assertEquals(1, v.getBonusFor(Race.Stat.INTELLIGENCE), "Veena clan should have +1 Intelligence");
        assertEquals(0, v.getBonusFor(Race.Stat.STRENGTH), "Unmodified stats should not be changed");
    }

    @Test
    public void testGarleanNameGenerator_HighSTR() {
        Garlean g = new Garlean();
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("Strength", 18);
        stats.put("Intelligence", 10);
        stats.put("Charisma", 8);
        String generatedGarleanName = g.randomNameGenerator(Sex.MALE, stats);
        assertTrue(generatedGarleanName.contains("pyr"), "A Garlean with high Strength should be assigned the title 'pyr'");
    }

    @Test
    public void testGarleanNameGenerator_HighINT() {
        Garlean g = new Garlean();
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("Strength", 3);
        stats.put("Intelligence", 18);
        stats.put("Charisma", 8);
        String generatedGarleanName = g.randomNameGenerator(Sex.FEMALE, stats);
        assertTrue(generatedGarleanName.contains("jen"), "A Garlean with high Intelligence should be assigned the title 'jen'");
    }

    @Test
    public void testGarleanNameGenerator_HighCHA() {
        Garlean g = new Garlean();
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("Strength", 7);
        stats.put("Intelligence", 10);
        stats.put("Charisma", 18);
        String generatedGarleanName = g.randomNameGenerator(Sex.FEMALE, stats);
        assertTrue(generatedGarleanName.contains("bas"), "A Garlean with high Charisma should be assigned the title 'bas'");
    }

    @Test
    public void testGarleanTieHigh() {
        Garlean g = new Garlean();
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("Strength", 16);
        stats.put("Intelligence", 16);
        stats.put("Charisma", 16);
        String generatedGarleanName = g.randomNameGenerator(Sex.FEMALE, stats);
        System.out.println("Generated Name: " + generatedGarleanName);
        assertTrue(generatedGarleanName.contains("pyr"), "Strength should win ties");
    }

    @Test
    public void testGarleanTieLow() {
        Garlean g = new Garlean();
        HashMap<String, Integer> stats = new HashMap<>();
        stats.put("Strength", 8);
        stats.put("Intelligence", 8);
        stats.put("Charisma", 8);
        String generatedGarleanName = g.randomNameGenerator(Sex.FEMALE, stats);
        System.out.println("Generated Name: " + generatedGarleanName);
        assertTrue(generatedGarleanName.contains("pyr"), "Strength should win ties");
    }
}