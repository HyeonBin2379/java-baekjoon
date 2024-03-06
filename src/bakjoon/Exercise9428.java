package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9428 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int[] infected = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] strike = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            double answer;
            if (infected[1] == strike[1]) {
                answer = 0.5 * (strike[0]-infected[0])/(12.0 - infected[0] + 1);
            } else {
                answer = 0.5 + (strike[1]-infected[1]-1) + (strike[0]-1)/12.0;
            }
            sb.append(String.format("%.4f\n", answer));
        }
        System.out.print(sb);
    }
}
