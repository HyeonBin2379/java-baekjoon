package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int trout = Integer.parseInt(br.readLine());
        int pike = Integer.parseInt(br.readLine());
        int pickerel = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i <= total; i += trout) {
            for (int j = 0; j <= total-i; j += pike) {
                for (int k = 0; k <= total-j; k += pickerel) {
                    int sum = i + j + k;
                    if (sum > 0 && sum <= total) {
                        System.out.printf("%d Brown Trout, %d Northern Pike, %d Yellow Pickerel\n", i/trout, j/pike, k/pickerel);
                        count++;
                    }
                }
            }
        }
        System.out.printf("Number of ways to catch fish: %d\n", count);
    }
}
