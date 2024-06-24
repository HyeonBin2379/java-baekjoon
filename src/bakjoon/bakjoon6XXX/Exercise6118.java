package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise6118 {

    private static final Map<Integer, List<Integer>> graph = new TreeMap<>();
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        setGraph(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited = new int[n+1];
        Arrays.fill(visited, -1);
        bfs();

        int maxDist = IntStream.rangeClosed(1, n).map(index -> visited[index]).max().getAsInt();
        int[] barnNum = IntStream.rangeClosed(1, n).filter(index -> visited[index] == maxDist).toArray();
        System.out.println(barnNum[0] + " " + maxDist + " " + barnNum.length);
    }

    private static void setGraph(int n) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    private static void bfs() {
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
    }
}
