package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13667 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                int[] level = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int count = 0;
                int checked = -1;
                for (int j = 0; j < 5; j++) {
                    if (level[j] <= 127) {
                        count++;
                        checked = j;
                    }
                }
                sb.append(count == 1 ? (char)('A'+checked) : "*").append("\n");
            }
        }
        System.out.print(sb);
    }
}
