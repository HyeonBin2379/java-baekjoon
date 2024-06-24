package bakjoon.bakjoon06XXX;

import java.util.Scanner;

public class Exercise6996 {
    private static boolean solveAnagrams(String first, String second ) {
        int len1 = first.length();
        int len2 = second.length();

        if (len1 != len2) {
            return false;
        }
        int[] letter1 = new int[26];
        int[] letter2 = new int[26];
        for (int i = 0; i < len1; i++) {
            letter1[first.charAt(i)-'a']++;
            letter2[second.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (letter1[i] != letter2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
