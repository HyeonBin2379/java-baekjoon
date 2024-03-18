package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3602 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tileCount = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(tileCount);

        int max = 0;
        for (int i = 1; i*i <= tileCount[0] + tileCount[1]; i++) {
            int w_total = i*i/2;
            int b_total = (i % 2 == 0) ? i*i/2 : i*i/2+1;
            if (w_total <= tileCount[0] && b_total <= tileCount[1]) {
                max = i;
            }
        }
        System.out.println(max == 0 ? "Impossible" : max);
    }
}
