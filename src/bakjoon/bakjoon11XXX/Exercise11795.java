package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int[] set = new int[3];
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                set[j] += Integer.parseInt(st.nextToken());
            }

            int min = Arrays.stream(set).min().getAsInt();
            if (min < 30) {
                sb.append("NO\n");
                continue;
            }
            set = Arrays.stream(set).map(value -> value - min).toArray();
            sb.append(min).append("\n");
        }
        System.out.print(sb);
    }
}
