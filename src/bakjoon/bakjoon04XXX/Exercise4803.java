package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise4803 {

    private static Map<Integer, List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            graph = new TreeMap<>();
            IntStream.rangeClosed(1, n).forEach(i -> graph.put(i, new ArrayList<>()));
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
            visited = new boolean[n+1];
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    count += isTree(i, -1) ? 1 : 0;
                }
            }
            graph.clear();
            sb.append(String.format("Case %d: ", ++testcase));
            if (count == 0) {
                sb.append("No trees.\n");
            } else if (count == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append(String.format("A forest of %d trees.\n", count));
            }
        }
        System.out.print(sb);
    }

    private static boolean isTree(int now, int parent) {
        visited[now] = true;
        for (int neighbor : graph.get(now)) {
            if (!visited[neighbor]) {
                if (!isTree(neighbor, now)) {
                    return false;
                }
            } else if (neighbor != parent) {
                // 이미 방문한 노드가 부모 노드가 아니면 사이클이 존재
                return false;
            }
        }
        return true;
    }
}
