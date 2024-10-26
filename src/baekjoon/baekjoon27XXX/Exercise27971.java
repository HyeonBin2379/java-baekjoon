package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise27971 {

    private static final List<Integer[]> ranges = new ArrayList<>();
    private static int[] magic, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        magic = new int[]{a, b};

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            ranges.add(new Integer[]{left, right});
        }

        visited = new int[n+1];
        Arrays.fill(visited, -1);
        bfs(n);
    }

    private static void bfs(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[0] = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (isInRanges(now)) {
                continue;
            }

            for (int j : magic) {
                int next = now + j;

                if (next > n || visited[next] != -1) {
                    continue;
                }
                visited[next] = visited[now] + 1;
                queue.offer(next);
            }
        }
        System.out.println(visited[n]);
    }

    private static boolean isInRanges(int value) {
        for (Integer[] range : ranges) {
            if (range[0] <= value && value <= range[1]) {
                return true;
            }
        }
        return false;
    }
}
