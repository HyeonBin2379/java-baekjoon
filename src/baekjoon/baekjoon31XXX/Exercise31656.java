package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31656 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (i == 0 || input[i-1] != input[i]) {
                System.out.print(input[i]);
            }
        }
    }
}