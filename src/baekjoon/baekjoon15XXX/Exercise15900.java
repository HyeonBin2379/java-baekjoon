package baekjoon.baekjoon15XXX;

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
import java.util.stream.IntStream;

public class Exercise15900 {

    private static boolean[] visited;
    private static int[] dist;
    private static final Map<Integer, List<Integer>> tree = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(1, n).forEach(i -> tree.put(i, new ArrayList<>()));
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(p).add(c);
            tree.get(c).add(p);
        }

        dist = new int[n+1];
        visited = new boolean[n+1];
        bfs();
        int answer = IntStream.rangeClosed(2, n).filter(i -> tree.get(i).size() == 1).map(i -> dist[i]).sum();
        System.out.println(answer % 2 == 0 ? "No" : "Yes");
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int next : tree.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[now]+1;
                    queue.add(next);
                }
            }
        }
    }
}
