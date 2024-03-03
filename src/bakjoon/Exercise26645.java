package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise26645 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        int[] result = {Math.min(level+8, 210), Math.min(level+4, 220), Math.min(level+2, 230), Math.min(level+1, 240)};
        int max = Arrays.stream(result).max().getAsInt();
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (max == result[i]) {
                answer = i+1;
            }
        }
        System.out.println(answer);
    }
}
