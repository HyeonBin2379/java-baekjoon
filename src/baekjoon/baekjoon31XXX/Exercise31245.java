package baekjoon.baekjoon31XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise31245 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder(Integer.toString(num[0]));
        for (int i = 1; i < 3; i++) {
            if (num[i-1] % 10 == num[i]/10) {
                sb.append("'").append(num[i] % 10);
            } else {
                sb.append(num[i]);
            }
        }
        System.out.println(sb);
    }
}
