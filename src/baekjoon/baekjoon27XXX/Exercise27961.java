package baekjoon.baekjoon27XXX;

import java.util.Scanner;

public class Exercise27961 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        long catCnt = 0;
        int answer = 0;
        while (catCnt != n) {
            if (catCnt == 0) {
                catCnt++;
            } else {
                catCnt = (catCnt >= n - catCnt) ? catCnt + (n - catCnt) : catCnt * 2;
            }
            answer++;
        }
        System.out.println(answer);
    }
}
