package bakjoon.bakjoon1XXX;

import java.util.Scanner;

public class Exercise1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = (sc.nextInt() / 100) * 100;
        int f = sc.nextInt();
        int answer = 0;
        for (int i = n; i % f != 0; i++) {
            answer++;
        }
        System.out.printf("%02d\n", answer);
    }
}
