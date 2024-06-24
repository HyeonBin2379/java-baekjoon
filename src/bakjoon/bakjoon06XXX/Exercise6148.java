package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise6148 {

    private static int n, b;
    private static int min = Integer.MAX_VALUE;
    private static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int index, int currentHeight) {
        if (currentHeight >= b) {
            min = Math.min(min, currentHeight-b);
            return;
        }
        if (index == n) {
            return;
        }
        dfs(index+1, currentHeight + height[index]);
        dfs(index+1, currentHeight);
    }
}
