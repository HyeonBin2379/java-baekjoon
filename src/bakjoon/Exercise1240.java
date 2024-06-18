package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise1240 {

    private static class Node {
        int num, dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }
    private static final Map<Integer, List<Node>> graph = new TreeMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        setGraph(n);
        for (int i = 0; i < n -1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, dist));
            graph.get(to).add(new Node(from, dist));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            visited = new boolean[n +1];
            System.out.println(bfs(from, to));
        }
    }

    private static void setGraph(int n) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    private static int bfs(int from, int to) {
        Queue<Node> queue = new LinkedList<>();
        visited[from] = true;
        queue.add(new Node(from, 0));

        int answer = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.num == to) {
                answer = now.dist;
                break;
            }

            for (Node node : graph.get(now.num)) {
                if (!visited[node.num]) {
                    visited[node.num] = true;
                    queue.add(new Node(node.num, now.dist + node.dist));
                }
            }
        }
        return answer;
    }
}
