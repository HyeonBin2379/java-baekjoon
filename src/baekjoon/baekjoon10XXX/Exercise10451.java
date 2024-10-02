package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10451 {

    private static int[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            graph = Arrays.stream(br.readLine().split(" ", n)).mapToInt(value -> Integer.parseInt(value)-1).toArray();
            visited = new boolean[n];

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int num) {
        visited[num] = true;
        if (!visited[graph[num]]) {
            dfs(graph[num]);
        }
    }
}
