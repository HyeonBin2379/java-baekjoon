package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20540 {
    private static final String[][] mbti = {{"E", "I"}, {"S", "N"}, {"T", "F"}, {"J", "P"}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        for (int i = 0; i < 4; i++) {
            input[i] = (input[i].equals(mbti[i][0])) ? mbti[i][1] : mbti[i][0];
        }
        System.out.println(String.join("", input));
    }
}
