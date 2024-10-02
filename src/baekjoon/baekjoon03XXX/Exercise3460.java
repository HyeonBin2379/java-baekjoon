package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String binary = Integer.toBinaryString(Integer.parseInt(br.readLine()));
            StringBuilder rev = new StringBuilder(binary).reverse();
            for (int j = 0; j < rev.length(); j++) {
                if (rev.charAt(j) == '1') {
                    sb.append(j).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
