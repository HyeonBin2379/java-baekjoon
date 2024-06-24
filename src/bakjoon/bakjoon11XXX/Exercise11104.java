package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11104 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] bits = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int answer = 0;
            for (int j = 23; j >= 0; j--) {
                if (bits[j] == 1) {
                    answer += (1L << 23 - j);
                }
            }
            System.out.println(answer);
        }
    }
}
