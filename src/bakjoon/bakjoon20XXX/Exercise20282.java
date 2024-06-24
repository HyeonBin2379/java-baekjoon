package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise20282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        int[] prefixSum = new int[c+1];
        prefixSum[0] = 100;

        for (int i = 1; i <= c; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(br.readLine());
        }
        System.out.println(Arrays.stream(prefixSum).max().getAsInt());
    }
}
