package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise6979 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] seq1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] seq2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int maxDist = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int dist = (k >= j && seq2[k] >= seq1[j]) ? k-j : 0;
                    maxDist = Math.max(dist, maxDist);
                }
            }
            System.out.printf("The maximum distance is %d\n\n", maxDist);
        }
    }
}
