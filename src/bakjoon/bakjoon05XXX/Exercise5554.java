package bakjoon.bakjoon05XXX;

import java.util.Scanner;

public class Exercise5554 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sec = new int[4];
        int total = 0;
        for (int i = 0; i < 4; i++) {
            sec[i] = sc.nextInt();
            total += sec[i];
        }
        sc.close();

        System.out.println(total / 60);
        System.out.println(total % 60);
    }
}
