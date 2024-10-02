package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15351 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int sum = br.readLine().chars().filter(value -> (char)value != ' ').map(value -> value-'A'+1).sum();
            System.out.println(sum == 100 ? "PERFECT LIFE" : sum);
        }
    }
}
