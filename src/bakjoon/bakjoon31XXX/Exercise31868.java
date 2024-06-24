package bakjoon.bakjoon31XXX;

import java.util.Scanner;

public class Exercise31868 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i < n; i++) {
            k /= 2;
        }
        System.out.println(k);
    }
}
