package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise26940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] choco = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bought = 0;
        for (int i = 1; i < n; i++) {
            if (choco[i-1] < choco[i]) {
                bought++;
            }
        }
        System.out.println(bought);
    }
}
