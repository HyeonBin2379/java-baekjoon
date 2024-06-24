package bakjoon.bakjoon17XXX;

import java.util.Scanner;

public class Exercise17009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] apple = {3, 2, 1};
        int[] banana = {3, 2, 1};
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                apple[i] *= sc.nextInt();
                sum1 += apple[i];
            } else {
                banana[i-3] *= sc.nextInt();
                sum2 += banana[i-3];
            }
        }
        if (sum1 == sum2) {
            System.out.println("T");
        } else {
            System.out.println((sum1 > sum2) ? "A" : "B");
        }
    }
}
