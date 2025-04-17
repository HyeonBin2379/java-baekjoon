package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1389 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static long[] dist;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));

        int m = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        long min = Long.MAX_VALUE;
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            dist = new long[n+1];
            Arrays.fill(dist, 1, n+1, -1);
            long total = bfs(i);
            if (total < min) {
                min = total;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static long bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int next : graph.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now]+1;
                    queue.add(next);
                }
            }
        }
        return Arrays.stream(dist, 1, n+1).sum();
    }
}
