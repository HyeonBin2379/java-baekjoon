package bakjoon.bakjoon2XXX;

import java.util.Scanner;

public class Exercise2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0, sum = 0;
        for (int i = 0; i < 10; i++) {
            sum -= sc.nextInt();
            max = Math.max(max, sum);
            sum += sc.nextInt();
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
