package baekjoon.baekjoon04XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise4153 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int[] sides = new int[3];
            for (int i = 0; i < 3; i++) {
                sides[i] = sc.nextInt();
            }
            if (Arrays.stream(sides).allMatch(value -> value == 0)) {
                break;
            }
            Arrays.sort(sides);

            if (sides[2]*sides[2] == (sides[0]*sides[0])+(sides[1]*sides[1])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
