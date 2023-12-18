package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise1389 {
    private static final Map<Integer, Set<Integer>> graph = new LinkedHashMap<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        dist = new int[nodeCount +1];
        for (int i = 1; i <= nodeCount; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        br.close();

        int minCount = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Integer user : graph.keySet()) {
            int count = bfs(user);
            if (minCount > count) {
                minCount = count;
                minIndex = user;
            }
        }
        System.out.println(minIndex);
    }

    public static int bfs(int user) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        Arrays.fill(dist, -1);
        queue.offer(user);
        dist[user] = 0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            for (Integer next : graph.get(now)) {
                if (dist[next] != -1) {
                    continue;
                }
                dist[next] = dist[now]+1;
                count += dist[next];
                queue.offer(next);
            }
        }
        return count;
    }
}
