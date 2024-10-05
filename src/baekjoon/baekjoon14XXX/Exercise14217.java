package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise14217 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        IntStream.range(0, n).forEach(num -> graph.add(num, new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int queryType = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            switch (queryType) {
                case 1 -> {
                    graph.get(from).add(to);
                    graph.get(to).add(from);
                }
                case 2 -> {
                    graph.get(from).remove(Integer.valueOf(to));
                    graph.get(to).remove(Integer.valueOf(from));
                }
            }
            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }

    private static String bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = IntStream.range(0, n).map(idx -> -1).toArray();
        visited[0] = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (visited[next] == -1) {
                    visited[next] = visited[now]+1;
                    queue.offer(next);
                }
            }
        }
        return Arrays.stream(visited)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(" "));
    }
}
