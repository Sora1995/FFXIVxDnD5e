package tests.java.main;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
public class StatAssignmentTest {
    @Test
    public void testRandomAssignment() {
        ArrayList<Integer> rolled = new ArrayList<>(Arrays.asList(13,15,14,11,8,8));
        ArrayList<Integer> shuffle = new ArrayList<>(rolled);

        String[] statNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
        HashMap<String, Integer> stats = new HashMap<>();

        Collections.shuffle(shuffle);
        for (int i = 0; i < statNames.length; i++) {
            stats.put(statNames[i], shuffle.get(i));
        }
        ArrayList<Integer> assignedStats = new ArrayList<>(stats.values());
        Collections.sort(rolled);
        Collections.sort(assignedStats);
        assertEquals(rolled, assignedStats, "Assigned stats must be an exact match");
        assertEquals(6, stats.size(), "There should be exactly 6 stats assigned");
    }
}
