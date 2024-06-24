package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14535 {

    private static final String[] month = {
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 0) {
                break;
            }

            int[] count = new int[12];
            for (int i = 0; i < n; i++) {
                int[] date = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                count[date[1]-1]++;
            }

            sb.append(String.format("Case #%d:\n", ++testCase));
            for (int i = 1; i <= 12; i++) {
                sb.append(String.format("%s:%s\n", month[i-1], "*".repeat(count[i-1])));
            }
        }
        System.out.print(sb);
    }
}
