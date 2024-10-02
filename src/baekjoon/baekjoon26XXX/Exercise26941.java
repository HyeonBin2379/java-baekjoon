package baekjoon.baekjoon26XXX;

import java.util.Scanner;

public class Exercise26941 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int block = sc.nextInt();
        int k = 1;

        int answer = 0;
        while (block >= k*k) {
            block -= (k*k);
            k += 2;
            answer++;
        }
        System.out.println(answer);
    }
}
