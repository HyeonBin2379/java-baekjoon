package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise9635 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] color = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (x == color[0]) {
                sb.append((y == color[n-1]) ? "BOTH\n" : "EASY\n");
            } else {
                sb.append((y == color[n-1]) ? "HARD\n" : "OKAY\n");
            }
        }
        System.out.print(sb);
    }
}
