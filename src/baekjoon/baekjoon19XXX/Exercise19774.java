package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise19774 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            int newNum = (num/100)*(num/100) + (num%100)*(num%100);
            sb.append((newNum % 7 == 1) ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
}
