package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise2606 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        visited = new boolean[n+1];
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.offer(1);

        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }
        return count;
    }
}
