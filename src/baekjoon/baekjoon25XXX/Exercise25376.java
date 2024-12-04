package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise25376 {

    private static int[] graph, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        for (int i = 0; i < n; i++) {
            start |= (Integer.parseInt(st.nextToken()) == 1) ? (1 << i) : 0;
        }

        graph = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                int exp = Integer.parseInt(st.nextToken())-1;
                graph[i] |= (1 << exp);
            }
            graph[i] |= (1 << i);
        }

        dist = new int[(1 << n)];
        Arrays.fill(dist, -1);
        bfs(start);
        System.out.println(dist[(1 << n)-1]);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < graph.length; i++) {
                if ((now & (1 << i)) != 0) {
                    continue;
                }
                int next = now ^ graph[i];
                if (dist[next] < 0) {
                    dist[next] = dist[now]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
