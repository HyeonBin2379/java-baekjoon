package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17487 {

    private static final String LEFT_HAND = "qwertyasdfgzxcvb";
    private static final String RIGHT_HAND = "uiophjklnm";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int other = (int) Arrays.stream(input).filter(s -> Character.isUpperCase(s.charAt(0))).count();
        int left = 0, right = 0;
        for (String letter : input) {
            if (LEFT_HAND.contains(letter.toLowerCase())) {
                left++;
            } else if (RIGHT_HAND.contains(letter.toLowerCase())) {
                right++;
            } else {
                other++;
            }
        }
        while (other-- > 0) {
            if (left <= right) {
                left++;
            } else {
                right++;
            }
        }
        System.out.println(left + " " + right);
    }
}
