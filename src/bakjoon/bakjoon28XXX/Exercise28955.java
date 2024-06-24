package bakjoon.bakjoon28XXX;

import java.util.Scanner;

public class Exercise28955 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder zeros = new StringBuilder("00");
        long score = 1;
        for (int i = 0; i < n; i++) {
            System.out.println(score + zeros.toString());
            score *= 2;
            if (Long.toString(score).length() > zeros.length()) {
                score = (score - score % 10 + 10) / 10;
                zeros.append('0');
            }
        }
    }
}
