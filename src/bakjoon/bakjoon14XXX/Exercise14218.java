package bakjoon.bakjoon14XXX;

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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise14218 {

    private static int[] visited;
    private static final Map<Integer, List<Integer>> graph = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(1, n).forEach(i -> graph.put(i, new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            visited = IntStream.rangeClosed(0, n).map(i -> -1).toArray();
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
            bfs(n);
        }
    }

    private static void bfs(int size) {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = 0;
        queue.add(1);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (visited[next] == -1) {
                    visited[next] = visited[now]+1;
                    queue.add(next);
                }
            }
        }
        System.out.println(IntStream.rangeClosed(1, size)
                .mapToObj(i -> Integer.toString(visited[i]))
                .collect(Collectors.joining(" ")));
    }
}
