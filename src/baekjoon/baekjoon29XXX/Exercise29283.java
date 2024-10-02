package baekjoon.baekjoon29XXX;

import java.util.Scanner;

public class Exercise29283 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long answer = 0;
        for (long i = 1; i <= k; i++) {
            answer += (i % 5 == 0) ? 30*i/5 : 30*(i/5+1);
        }
        System.out.println(answer);
    }
}
