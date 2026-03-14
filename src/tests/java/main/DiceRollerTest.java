package tests.java.main;

import main.DiceRoller;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class DiceRollerTest {

    @Test
    public void testInsertionSort() {
        ArrayList<Integer> unsorted = new ArrayList<>(Arrays.asList(5, 4, 1, 6));
        DiceRoller.insertionSort(unsorted);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 4, 5, 6));
        assertEquals(expected, unsorted, "The dice should be sorted from lowest to highest");
    }

    @Test
    public void testStatRollAlwaysWithinBounds() {
        int roll = 0;
        for (int i = 0; i < 1000; i++) {
            roll = DiceRoller.statRoll();
            assertTrue(roll >= 3 && roll <= 18, "A rolled stat must be between 3 and 18. The broken roll was: " + roll);
        }
    }
    @Test
    public void testFourOfAKind() {
        ArrayList<Integer> unsorted = new ArrayList<>(Arrays.asList(6, 6, 6, 6));
        DiceRoller.insertionSort(unsorted);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(6, 6, 6, 6));
        assertEquals(expected, unsorted, "The dice should be sorted from lowest to highest");
    }

    @Test
    public void testPattern() {
        ArrayList<Integer> unsorted = new ArrayList<>(Arrays.asList(6, 2, 6, 2));
        DiceRoller.insertionSort(unsorted);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 2, 6, 6));
        assertEquals(expected, unsorted, "The dice should be sorted from lowest to highest");
    }
}