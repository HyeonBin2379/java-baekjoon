package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17530 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int max = 0;
        int[] candidate = new int[len];
        for (int i = 0; i < len; i++) {
            candidate[i] = Integer.parseInt(br.readLine());
            max = Math.max(candidate[i], max);
        }
        System.out.println(max == candidate[0] ? "S" : "N");
    }
}
