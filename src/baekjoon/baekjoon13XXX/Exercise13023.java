package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise13023 {
    private static boolean[] visited;
    private static final Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
    private static boolean arrived = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        visited = new boolean[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int me = Integer.parseInt(st.nextToken());
            int friend = Integer.parseInt(st.nextToken());
            graph.get(me).add(friend);
            graph.get(friend).add(me);
        }
        br.close();

        int depth = 1;
        for (int i = 0; i < visited.length; i++) {
            dfs(i, depth);
            if (arrived) {
                break;
            }
        }

        if (arrived) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

    public static void dfs(Integer nodeNum, int depth) {
        if (depth == 5) {
            arrived = true;
            return;
        }
        visited[nodeNum] = true;
        for (Integer friend : graph.get(nodeNum)) {
            if (!visited[friend]) {
                dfs(friend, depth+1);
            }
        }
        visited[nodeNum] = false;
    }
}
