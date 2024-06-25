package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise18232 {

    private static int[] visited;
    private static final int[] move = {-1, 1};
    private static final List<List<Integer>> teleport = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, n).forEach(i -> teleport.add(new ArrayList<>()));

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            teleport.get(from).add(to);
            teleport.get(to).add(from);
        }

        visited = new int[n+1];
        bfs(start, end, n);
    }

    private static void bfs(int start, int end, int len) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == end) {
                System.out.println(visited[now]);
                return;
            }

            for (int nextMove : move) {
                int next = now + nextMove;
                if (next < 1 || next > len || visited[next] != 0) {
                    continue;
                }
                visited[next] = visited[now]+1;
                queue.add(next);
            }
            for (int next : teleport.get(now)) {
                if (visited[next] == 0) {
                    visited[next] = visited[now]+1;
                    queue.add(next);
                }
            }
        }
    }
}
