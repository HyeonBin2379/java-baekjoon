package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10174 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            System.out.println(isPalindrome(br.readLine().toLowerCase()) ? "Yes" : "No");
        }
    }

    private static boolean isPalindrome(String input) {
        int len = input.length();
        for (int i = 0; i < len/2; i++) {
            if (input.charAt(i) != input.charAt(len-1-i)) {
                return false;
            }
        }
        return true;
    }
}
