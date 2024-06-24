package bakjoon.bakjoon20XXX;

import java.util.Scanner;

public class Exercise20233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[4];
        for (int i = 0; i < 4; i++) {
            data[i] = sc.nextInt();
        }
        int t = sc.nextInt();
        sc.close();

        long total1 = (t > 30) ? data[0] + (long) (t - 30) * data[1] * 21 : data[0];
        long total2 = (t > 45) ? data[2] + (long) (t - 45) * data[3] * 21 : data[2];
        System.out.println(total1 + " " + total2);
    }
}
