package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Exercise12186 {
    private static Map<String, Integer> count;
    private static Map<String, String> paths;
    private static List<String> stops;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int n = Integer.parseInt(br.readLine());

            count = new LinkedHashMap<>();
            paths = new LinkedHashMap<>();
            while (n-- > 0) {
                String from = br.readLine();
                String to = br.readLine();

                count.put(from, count.getOrDefault(from, 0)+1);
                count.put(to, count.getOrDefault(to, 0)+1);
                paths.put(from, to);
            }

            stops = new ArrayList<>(count.keySet());
            visited = new boolean[stops.size()];
            String start = count.keySet().stream()
                    .filter(stop -> count.get(stop) == 1 && paths.containsKey(stop))
                    .findFirst()
                    .get();
            sb.append(String.format("Case #%d: %s\n", i, bfs(start)));
        }
        System.out.print(sb);
    }

    private static String bfs(String start) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        visited[stops.indexOf(start)] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            String now = queue.poll();
            String next = paths.get(now);
            result.add(String.format("%s-%s", now, next));

            if (!visited[stops.indexOf(next)] && count.get(next) > 1 && paths.containsKey(next)) {
                visited[stops.indexOf(next)] = true;
                queue.offer(next);
            }
        }
        return String.join(" ", result);
    }
}
