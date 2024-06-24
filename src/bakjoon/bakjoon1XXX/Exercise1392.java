package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1392 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] sheet = new int[n+1];
        int[] prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sheet[i] = Integer.parseInt(br.readLine());
            prefixSum[i] = prefixSum[i-1] + sheet[i];
        }

        for (int i = 0; i < q; i++) {
            int time = Integer.parseInt(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (prefixSum[j-1] <= time && time < prefixSum[j]) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
