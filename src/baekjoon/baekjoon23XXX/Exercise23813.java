package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise23813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            String newStr = (input.charAt(n-1) + input).substring(0, n);
            sum += Long.parseLong(newStr);
            input = newStr;
        }
        System.out.println(sum);
    }
}
