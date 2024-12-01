package baekjoon.baekjoon32XXX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise32801 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] answer = new int[3];
        for (int i = 1; i <= num; i++) {
            if (i % a == 0 && i % b == 0) {
                answer[2]++;
                continue;
            }
            if (i % a == 0) {
                answer[0]++;
            }
            if (i % b == 0) {
                answer[1]++;
            }
        }
        System.out.println(Arrays.stream(answer).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
