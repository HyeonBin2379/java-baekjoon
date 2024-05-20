package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1254 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (isPalindrome(input.substring(i))) {
                System.out.println(i+input.length());
                return;
            }
        }
        System.out.println(input.length() * 2);
    }

    private static boolean isPalindrome(String input) {
        for (int i = 0; i <= input.length()/2; i++) {
            if (input.charAt(i) != input.charAt(input.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
