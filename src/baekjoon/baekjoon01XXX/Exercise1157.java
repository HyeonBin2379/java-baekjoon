package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1157 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[26];
        char[] input = sc.nextLine().toUpperCase().toCharArray();

        int max = 0;
        for (char c : input) {
            count[c-'A']++;
            max = Math.max(max, count[c-'A']);
        }

        char answer = ' ';
        for (int i = 0; i < 26; i++) {
            if (max == count[i]) {
                answer = (answer == ' ') ? (char)('A'+i) : '?';
            }
        }
        System.out.println(answer);
    }
}
