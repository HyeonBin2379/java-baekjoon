package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1919 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.nextLine().toCharArray();
        int[] str1Count = new int[26];
        for (char letter : str1) {
            str1Count[letter-'a']++;
        }

        char[] str2 = sc.nextLine().toCharArray();
        int[] str2Count = new int[26];
        for (char letter : str2) {
            str2Count[letter-'a']++;
        }
        sc.close();

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(str1Count[i] - str2Count[i]);
        }
        System.out.println(count);
    }
}
