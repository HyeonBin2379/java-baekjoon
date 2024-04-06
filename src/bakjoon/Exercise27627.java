package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27627 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 1; i < input.length(); i++) {
            if (isPalindrome(input.substring(0, i)) && isPalindrome(input.substring(i))) {
                System.out.println(input.substring(0,i) + " " + input.substring(i));
                return;
            }
        }
        System.out.println("NO");
    }

    public static boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }
}
