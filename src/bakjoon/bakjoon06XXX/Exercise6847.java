package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise6847 {

    private static final Map<Integer, Integer> friends = new HashMap<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            friends.put(x, y);
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) {
                break;
            }
            bfs(a, b);
        }
        br.close();
        System.out.print(sb);
    }

    private static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();

        queue.add(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            int dist = distance.get(now);

            if (now == target) {
                sb.append(String.format("Yes %d\n", Math.max(dist-1, 0))); // 거리가 0이 되는 경우도 고려
                return;
            }

            if (friends.containsKey(now)) {
                int next = friends.get(now);
                if (!distance.containsKey(next)) {
                    queue.add(next);
                    distance.put(next, dist + 1);
                }
            }
        }
        sb.append("No\n");
    }
}
