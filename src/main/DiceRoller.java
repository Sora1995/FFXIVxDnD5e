package main;

import java.util.*;

public class DiceRoller {
    public static int statRoll() {
        Random rand = new Random();
        ArrayList<Integer> dice = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            dice.add(rand.nextInt(6) + 1);

        }
        System.out.println(dice);
        insertionSort(dice);
        return dice.get(1) +  dice.get(2) + dice.get(3);
    }
    public static void insertionSort(ArrayList<Integer> dice) {
        int key;
        for (int i = 1; i < dice.size(); i++) {
            key = dice.get(i);
            int j = i - 1;
            while (j >= 0 && dice.get(j) > key) {
                dice.set(j + 1, dice.get(j));
                j--;
            }
            dice.set(j + 1, key);
        }
    }
}

