package baekjoon.baekjoon31XXX;

import java.util.Scanner;

public class Exercise31000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = (2*n+1)*(2*n+1);
        for (int a = -n; a <= n; a++) {
            if (a == 0) {   // a = 0일 때는 항등식
                continue;
            }
            for (int b = -n; b <= n; b++) {
                if (Math.abs(1-a-b) <= n) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
