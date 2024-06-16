package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25706 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[n];

        for (int i = n-1; i >= 0; i--) {
            int step = i + height[i] + 1;
            if (step < n) {
                result[i] = result[step]+1;
            } else {
                result[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(value -> sb.append(value).append(" "));
        System.out.println(sb);
    }
}
