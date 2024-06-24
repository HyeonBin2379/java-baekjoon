package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int[] cnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int answer = 0;
            for (int j = l; j <= h; j++) {
                if (isDivided(cnt, j)) {
                    answer = j;
                    break;
                }
            }
            sb.append(String.format("Case #%d: ", i)).append(answer > 0 ? answer : "NO").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isDivided(int[] cnt, int num) {
        for (int j : cnt) {
            if (j % num != 0 && num % j != 0) {
                return false;
            }
        }
        return true;
    }
}
