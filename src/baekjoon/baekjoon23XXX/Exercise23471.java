package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise23471 {

    private static final Map<Integer, List<Integer>> graph = new TreeMap<>();
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(1, n).forEach(index -> graph.putIfAbsent(index, new ArrayList<>()));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        if (graph.get(x).isEmpty()) {
            System.out.println(-1);
            return;
        }

        visited = new boolean[2][n+1];
        bfs(x);
        System.out.println(IntStream.rangeClosed(1, n)
                .filter(num -> visited[y%2][num])
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" ")));
    }

    private static void bfs(int start) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        visited[0][start] = true;
        queue.offer(new Integer[]{0, start});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int next : graph.get(now[1])) {
                if (!visited[(now[0]+1) % 2][next]) {
                    visited[(now[0]+1)%2][next] = true;
                    queue.add(new Integer[]{now[0]+1, next});
                }
            }
        }
    }
}
