package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] prefixSum = new int[11];
        for (int i = 1; i <= 10; i++) {
            int score = Integer.parseInt(br.readLine());
            prefixSum[i] = prefixSum[i-1] + score;
        }

        for (int i = 1; i <= 10; i++) {
            if (prefixSum[i] >= 100) {
                if (Math.abs(prefixSum[i]-100) <= Math.abs(100-prefixSum[i-1])) {
                    System.out.println(prefixSum[i]);
                } else {
                    System.out.println(prefixSum[i-1]);
                }
                return;
            }
        }
        System.out.println(prefixSum[10]);
    }
}
