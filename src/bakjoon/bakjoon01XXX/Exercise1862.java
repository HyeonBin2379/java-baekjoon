package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1862 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int answer = 0;
        int len = Integer.toString(num).length();
        for (int i = 0; i < len; i++) {
            int digit = num % 10;
            answer += (digit > 4) ? (digit-1)*Math.pow(9, i) : digit*Math.pow(9, i);
            num /= 10;
        }
        System.out.println(answer);
    }
}
