package baekjoon.baekjoon16XXX;

import java.util.Scanner;

public class Exercise16676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long maxSalary = sc.nextLong();

        int answer = 1;
        long limit = 11;
        while (maxSalary >= limit) {
            limit = (limit * 10) + 1;
            answer++;
        }
        System.out.println(answer);
    }
}
