package baekjoon.baekjoon14XXX;

import java.util.Scanner;

public class Exercise14782 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                sum += (i != num/i) ? num/i : 0;
            }
        }
        System.out.println(sum);
    }
}
