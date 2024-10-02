package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1980 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        sc.close();

        int maxBurgers = 0;
        int minCoke = t;
        for (int i = 0; i*n <= t; i++) {
            for (int j = 0; j*m <= t; j++) {
                int totalTime = i * n + j * m;
                if (totalTime <= t) {
                    int coke = t - totalTime;
                    int totalBurgers = i + j;
                    if (coke < minCoke || (coke == minCoke && totalBurgers > maxBurgers)) {
                        maxBurgers = totalBurgers;
                        minCoke = coke;
                    }
                }
            }
        }
        System.out.println(maxBurgers + " " + minCoke);
    }
}
