package baekjoon.baekjoon24XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise24302 {

    private enum DeliveryA {
        ONE(57, 30, Integer.MAX_VALUE),
        TWO(1700, 20, 30),
        THREE(1200, 10, 20),
        FOUR(700, 5, 10),
        FIVE(400, -1, 5);

        private final int cost;
        private final int min, max;

        DeliveryA(int cost, int min, int max) {
            this.cost = cost;
            this.min = min;
            this.max = max;
        }

        public static int getCost(int dist) {
            DeliveryA result = Arrays.stream(DeliveryA.values())
                    .filter(deliveryA -> deliveryA.findRange(dist))
                    .findFirst()
                    .orElse(FIVE);
            if (result == ONE) {
                return result.cost * dist;
            } else {
                return result.cost;
            }
        }
        private boolean findRange(int dist) {
            return dist > min && dist <= max;
        }
    }
    private enum DeliveryB {
        ONE(925, 55, 40, Integer.MAX_VALUE),
        TWO(325, 70, 20, 40),
        THREE(125, 80, 5, 20),
        FOUR(100, 85, 2, 5),
        FIVE(90, 90, -1, 2);

        private final int baseRate, perKilo;
        private final int min, max;

        DeliveryB(int baseRate, int perKilo, int min, int max) {
            this.baseRate = baseRate;
            this.perKilo = perKilo;
            this.min = min;
            this.max = max;
        }

        public static int getCost(int dist) {
            DeliveryB result = Arrays.stream(DeliveryB.values())
                    .filter(deliveryB -> deliveryB.findRange(dist))
                    .findFirst()
                    .orElse(FIVE);
            return result.baseRate + result.perKilo * dist;
        }
        private boolean findRange(int dist) {
            return dist > min && dist <= max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt()/1000;
        int b = sc.nextInt()/1000;

        int total = Math.min(DeliveryA.getCost(a), DeliveryB.getCost(a))
                + Math.min(DeliveryA.getCost(b), DeliveryB.getCost(b));
        System.out.printf("%d.%02d\n", total/100, total%100);
    }
}
