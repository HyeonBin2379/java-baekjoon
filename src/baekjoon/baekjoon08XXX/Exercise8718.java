package baekjoon.baekjoon08XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise8718 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int k = sc.nextInt();
        double[] snowball = {1.0, 2.0, 4.0};
        snowball = Arrays.stream(snowball).map(operand -> (7*k)/operand).toArray();
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            double total = snowball[i]*1000;
            if (x*1000-(int)total < 0) {
                continue;
            }
            answer = Math.max(answer, (int) total);
        }
        System.out.println(answer);
    }
}
