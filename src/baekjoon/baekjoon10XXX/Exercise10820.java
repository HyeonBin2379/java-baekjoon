package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10820 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            char[] str = input.toCharArray();
            int[] result = new int[4];
            for (char c : str) {
                if ('a' <= c && c <= 'z') {
                    result[0]++;
                } else if ('A' <= c && c <= 'Z') {
                    result[1]++;
                } else if ('0' <= c && c <= '9') {
                    result[2]++;
                } else {
                    result[3]++;
                }
            }
            Arrays.stream(result).forEach(value -> System.out.print(value + " "));
            System.out.println();
        }
    }
}
