package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14696 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int rounds = Integer.parseInt(br.readLine());

        for (int i = 0; i < rounds; i++) {
            int[] a = getCount(br.readLine());
            int[] b = getCount(br.readLine());
            sb.append(getResult(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    private static int[] getCount(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int[] cnt = new int[5];
        for (int i = 0; i < n; i++) {
            int type = Integer.parseInt(st.nextToken());
            cnt[type]++;
        }
        return cnt;
    }

    private static String getResult(int[] a, int[] b) {
        for (int i = 4; i > 0; i--) {
            if (a[i] != b[i]) {
                return a[i] > b[i] ? "A" : "B";

            }
        }
        return "D";
    }
}
