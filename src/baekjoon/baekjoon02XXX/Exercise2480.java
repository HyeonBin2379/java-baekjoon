package baekjoon.baekjoon02XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2480 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dices = new int[3];
        for (int i = 0; i < 3; i++) {
            dices[i] = sc.nextInt();
        }
        Arrays.sort(dices);

        int cnt = (int) Arrays.stream(dices).distinct().count();
        switch (cnt) {
            case 1 -> System.out.println(10000 + dices[0] * 1000);
            case 2 -> {
                int reward = 1000;
                reward += (dices[0] == dices[1]) ? dices[0] * 100 : dices[2] * 100;
                System.out.println(reward);
            }
            case 3 -> System.out.println(dices[2] * 100);
        }
    }
}
