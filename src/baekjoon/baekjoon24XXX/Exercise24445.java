package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise24445 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static int count;
    private static int[] answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int r = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        visited = new boolean[n+1];
        answer = new int[n+1];
        bfs(r);
        IntStream.rangeClosed(1, n).map(idx -> answer[idx]).forEach(System.out::println);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            answer[now] = ++count;

            graph.get(now).sort(Comparator.reverseOrder());
            for (int next : graph.get(now)) {
                if (!visited[next] && answer[next] == 0) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
