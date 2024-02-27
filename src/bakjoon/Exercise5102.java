package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[0] == 0 && input[1] == 0) {
                break;
            }
            int remained = input[0]-input[1];
            if (remained % 2 == 1) {
                if (remained >= 3) {
                    sb.append(String.format("%d %d\n", (remained-3)/2, 1));
                } else {
                    sb.append(String.format("%d %d\n", 0, 0));
                }
            } else {
                sb.append(String.format("%d %d\n", remained/2, 0));
            }
        }
        System.out.print(sb);
    }
}
