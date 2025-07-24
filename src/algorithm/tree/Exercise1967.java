package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1967 {

    static class Node {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    private static final List<List<Node>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(p).add(new Node(c, w));
            graph.get(c).add(new Node(p, w));
        }

        answer = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int curr, int dist) {
        visited[curr] = true;
        for (Node next : graph.get(curr)) {
            if (!visited[next.index]) {
                dfs(next.index, dist + next.weight);
            }
        }
        answer = Math.max(dist, answer);
    }
}
