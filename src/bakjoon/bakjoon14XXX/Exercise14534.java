package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14534 {

    private static char[] input;
    private static boolean[] visited;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            input = br.readLine().toCharArray();
            visited = new boolean[input.length];
            sb.append(String.format("Case # %d:\n", i));
            backtracking(0, "");
        }
        System.out.print(sb);
    }

    private static void backtracking(int len, String str) {
        if (len == input.length) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtracking(len+1, str + input[i]);
            visited[i] = false;
        }
    }
}
