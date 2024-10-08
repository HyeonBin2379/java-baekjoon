package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Exercise28280 {

    private static final int[] move = {1, 2};
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            visited = new int[(int)(4*1e6)+1];
            Arrays.fill(visited, -1);
            bfs(n);
        }
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == n) {
                System.out.println(visited[n]);
                return;
            }

            for (int j : move) {
                int next = (j == 1) ? now - 1 : now * 2;
                if (next < 0 || next > (int)(4 * 1e6) || visited[next] != -1) {
                    continue;
                }
                visited[next] = visited[now]+1;
                queue.offer(next);
            }
        }
        System.out.println("Wrong proof!");
    }
}
