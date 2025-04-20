package baekjoon.baekjoon02XXX;

import java.util.Scanner;

public class Exercise2745 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();
        int base = Integer.parseInt(sc.nextLine().trim());

        int answer = 0;
        for (int i = 0; i < input.length; i++) {
            int idx = input.length-1-i;
            int digit = Character.isDigit(input[idx]) ? input[idx]-'0' : 10+(input[idx]-'A');
            answer += digit*(int)Math.pow(base, i);
        }
        System.out.println(answer);
    }
}
