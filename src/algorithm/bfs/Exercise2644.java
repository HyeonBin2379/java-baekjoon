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

public class Exercise2644 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        dist = new int[n+1];
        Arrays.fill(dist, -1);
        bfs(a, b);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int next : graph.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now]+1;
                    queue.offer(next);
                }
            }
        }

        System.out.println(dist[end]);
    }
}
