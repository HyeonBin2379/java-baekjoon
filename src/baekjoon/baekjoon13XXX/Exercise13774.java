package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13774 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            sb.append(makePalindrome(input)).append("\n");
        }
        System.out.print(sb);
    }

    private static String makePalindrome(String input) {
        for (int i = 0; i < input.length(); i++) {
            StringBuilder temp = new StringBuilder(input);
            String newStr = temp.deleteCharAt(i).toString();
            if (isPalindrome(newStr)) {
                return newStr;
            }
        }
        return "not possible";
    }
    private static boolean isPalindrome(String str) {
        for (int i = 0; i <= str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
