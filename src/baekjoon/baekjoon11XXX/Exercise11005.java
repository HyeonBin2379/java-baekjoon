package baekjoon.baekjoon11XXX;

import java.util.Scanner;

public class Exercise11005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int base = sc.nextInt();

        StringBuilder answer = new StringBuilder();
        while (num > 0) {
            int digit = num % base;
            answer.append(digit >= 10 ? (char)('A'+(digit-10)) : (char)(digit+'0'));
            num /= base;
        }
        System.out.println(answer.reverse());
    }
}
