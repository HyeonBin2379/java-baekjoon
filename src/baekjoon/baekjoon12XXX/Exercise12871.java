package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pattern = br.readLine();
        String input = br.readLine();
        int n1 = pattern.length();
        int n2 = input.length();

        String str1 = pattern.repeat(n2);
        String str2 = input.repeat(n1);
        System.out.println(str1.equals(str2) ? 1 : 0);
    }
}
