package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1240 {

    static class Node {
        int index;
        long dist;

        public Node(int index, long dist) {
            this.dist = dist;
            this.index = index;
        }
    }

    private static final List<List<Node>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, dist));
            graph.get(to).add(new Node(from, dist));
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            visited = new boolean[n+1];
            System.out.println(bfs(from, to));
        }
    }

    private static long bfs(int from, int to) {
        Queue<Node> queue = new LinkedList<>();
        visited[from] = true;
        queue.offer(new Node(from, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.index == to) {
                return now.dist;
            }

            for (Node next : graph.get(now.index)) {
                if (!visited[next.index]) {
                    visited[next.index] = true;
                    queue.offer(new Node(next.index, now.dist+next.dist));
                }
            }
        }
        return 0;
    }
}
