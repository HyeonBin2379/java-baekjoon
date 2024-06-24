package bakjoon.bakjoon06XXX;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exercise6995 {

    private static class Card {
        int value;
        String suit;

        public final static String[] suitNames = {
                "Elf", "Man", "Hobbit", "Ent", "Ork"
        };

        public Card(int valueIn, int suitIn) {
            if (valueIn < 1 || valueIn > 21) {
                throw new RuntimeException("Illegal card value attempted." +
                        " The " + "acceptible range is 1 to 21.  You tried " + valueIn);
            }
            if (suitIn < 0 || suitIn > 4) {
                throw new RuntimeException("Illegal suit attempted." +
                        " The  " + "acceptible range is 0 to 4.  You tried " + suitIn);
            }

            this.suit = suitNames[suitIn];
            this.value = valueIn;
        }

        public int getValue() { return value; }

        public String getSuit() { return suit; }
    }

    private static boolean detectSpread(Card[] handOfCards) {
        Set<Integer> values = new HashSet<>(List.of(1, 2, 4, 8, 16));
        Set<Integer> inHand = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            inHand.add(handOfCards[i].getValue());
        }
        return inHand.containsAll(values);
    }


    private static boolean detectRainbow(Card[] handOfCards) {
        Set<String> suits = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            suits.add(handOfCards[i].getSuit());
        }
        return suits.size() == 5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfTestCases = sc.nextInt();

        for (int testCase=0; testCase < numOfTestCases; testCase++) {
            Card[] handOfCards = new Card[5];
            for(int card=0; card<5; card++)
            {
                int suit = sc.nextInt();
                int value = sc.nextInt();
                handOfCards[card] = new Card(value, suit);
            }

            if (detectSpread(handOfCards)) {
                System.out.print("Have a spread.          ");
            }
            else {
                System.out.print("Do not have a spread.   ");
            }

            if (detectRainbow(handOfCards)) {
                System.out.println("Have a rainbow.");
            }
            else {
                System.out.println("Do not have a rainbow.");
            }
        }

        sc.close();
    }
}
