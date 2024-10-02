package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3943 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            int max = num;
            while (num != 1) {
                num = (num % 2 == 0) ? num/2 : num*3+1;
                max = Math.max(num, max);
            }
            System.out.println(max);
        }
    }
}
