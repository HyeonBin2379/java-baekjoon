package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            if (isPalindrome(input)) {
                sb.append(0).append("\n");
            } else {
                sb.append(isPseudoPalindrome(input, input.length())).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean isPalindrome(String input) {
        StringBuilder sb = new StringBuilder(input);
        return input.contentEquals(sb.reverse());
    }

    private static int isPseudoPalindrome(String input, int len) {
        int left = 0, right = len-1;
        int answer = 2;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                StringBuilder deleteLeft = new StringBuilder(input).deleteCharAt(left);
                StringBuilder deleteRight = new StringBuilder(input).deleteCharAt(right);
                if (isPalindrome(deleteLeft.toString()) || isPalindrome(deleteRight.toString())) {
                    answer = 1;
                }
                break;
            }
            left++;
            right--;
        }
        return answer;
    }
}
