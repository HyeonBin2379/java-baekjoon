package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise25418 {

    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new int[k+1];
        Arrays.fill(visited, -1);
        bfs(a, k);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) {
                System.out.println(visited[end]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = now;
                if (i == 0) {
                    next += 1;
                } else {
                    next *= 2;
                }

                if (next > end || visited[next] != -1) {
                    continue;
                }
                visited[next] = visited[now] + 1;
                queue.add(next);
            }
        }
    }
}
