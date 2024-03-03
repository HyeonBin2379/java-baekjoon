package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (data[0] == 0 && data[1] == 0 && data[2] == 0) {
                break;
            }
            int diff = (int) Math.round(((double) data[0] / data[1] - (double) data[0] / data[2]) * 3600.0);
            sb.append(String.format("%d:%02d:%02d\n", diff/3600, (diff%3600) /60, diff %60));
        }
        System.out.print(sb);
    }
}
