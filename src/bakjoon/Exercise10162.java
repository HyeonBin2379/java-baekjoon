package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise10162 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input % 10 != 0) {
            System.out.println(-1);
            return;
        }

        int[] sec = {300, 60, 10};
        int[] count = new int[3];
        for (int i = 0; i < 3; i++) {
            count[i] = input/sec[i];
            input %= sec[i];
        }
        Arrays.stream(count).forEach(value -> System.out.print(value + " "));
    }
}
