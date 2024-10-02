package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] input = br.readLine().toCharArray();
            int len = input.length;
            boolean do_it = true;
            for (int j = 0; j <= len/2; j++) {
                do_it = (input[j] == input[len-1-j]);
            }
            sb.append(do_it ? "Do-it\n" : "Do-it-Not\n");
        }
        System.out.print(sb);
    }
}
