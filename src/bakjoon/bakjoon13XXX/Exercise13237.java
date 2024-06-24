package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise13237 {

    private static int[] parent, height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = Integer.parseInt(br.readLine());
        }

        height = new int[n+1];
        Arrays.fill(height, -1);
        for (int i = 1; i <= n; i++) {
            if (height[i] == -1) {
                dfs(i);
            }
            System.out.println(height[i]);
        }
    }

    private static int dfs(int nodeNum) {
        if (height[nodeNum] != -1) {
            return height[nodeNum];
        }
        height[nodeNum] = parent[nodeNum] == -1 ? 0 : dfs(parent[nodeNum]) + 1;
        return height[nodeNum];
    }
}
