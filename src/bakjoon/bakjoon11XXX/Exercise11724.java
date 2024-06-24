package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise11724 {
    private static boolean[] visited;
    private static final Map<Integer, List<Integer>> graph = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        visited = new boolean[nodeCount+1];
        for (int i = 1; i <= nodeCount; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.println(count);
        br.close();
    }

    public static void dfs(int currentNode) {
        visited[currentNode] = true;
        for (Integer adjNode : graph.get(currentNode)) {
            if (!visited[adjNode]) {
                dfs(adjNode);
            }
        }
    }
}
