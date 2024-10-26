package baekjoon.baekjoon10XXX;

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

public class Exercise10917 {

    private static int[] visited;
    private static final List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            graph.get(x).add(y);
        }

        visited = new int[n];
        Arrays.fill(visited, -1);
        bfs(n);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = 0;
        queue.offer(0);

        int count = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (visited[next] == -1) {
                    visited[next] = visited[now]+1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(visited[n-1]);
    }
}
