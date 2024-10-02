package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise6207 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static boolean[] visited;
    private static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] startPoint = new int[k];
        for (int i = 0; i < k; i++) {
            startPoint[i] = Integer.parseInt(br.readLine())-1;
        }

        IntStream.range(0, n).forEach(i -> graph.add(new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(to);
        }

        count = new int[n];
        for (int i = 0; i < k; i++) {
            visited = new boolean[n];
            bfs(startPoint[i]);
        }
        System.out.println(Arrays.stream(count).filter(cnt -> cnt == k).count());
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        count[start]++;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    count[next]++;
                    queue.add(next);
                }
            }
        }
    }
}
