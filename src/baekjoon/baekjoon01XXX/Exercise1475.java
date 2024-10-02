package baekjoon.baekjoon01XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int[] inputNumber = new int[9];
        int[] numberSet = {1, 1, 1, 1, 1, 1, 2, 1, 1};

        for (int num : input) {
            if (num == 9) {
                inputNumber[6]++;
            } else {
                inputNumber[num]++;
            }
        }

        int max = 0;
        for (int i = 0; i < 9; i++) {
            int quantity = inputNumber[i] / numberSet[i];
            int need = (inputNumber[i] % numberSet[i] == 0) ? quantity : quantity+1;
            max = Math.max(max, need);
        }
        System.out.println(max);
    }
}
