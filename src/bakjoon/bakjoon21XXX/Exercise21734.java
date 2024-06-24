package bakjoon.bakjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise21734 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for (int c : input) {
            int num = c;
            int digitSum = 0;
            while (num > 0) {
                digitSum += num % 10;
                num /= 10;
            }
            System.out.println(String.valueOf((char)c).repeat(digitSum));
        }
    }
}
