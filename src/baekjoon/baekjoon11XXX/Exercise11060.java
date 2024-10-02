package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise11060 {

    private static int n;
    private static int[] maze;
    private static boolean[] visited;
    private static class Move {
        int location, moveTime;

        public Move(int location, int moveTime) {
            this.location = location;
            this.moveTime = moveTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        maze = new int[n+1];
        IntStream.rangeClosed(1, n).forEach(i -> maze[i] = Integer.parseInt(st.nextToken()));

        visited = new boolean[n+1];
        bfs(n);
    }

    private static void bfs(int dest) {
        Queue<Move> queue = new LinkedList<>();
        visited[1] = true;
        queue.add(new Move(1, 0));

        while (!queue.isEmpty()) {
            Move now = queue.poll();
            int cur = now.location;
            int time = now.moveTime;

            if (cur == dest) {
                System.out.println(time);
                return;
            }

            for (int i = 1; i <= maze[cur] && cur+i <= n; ++i) {
                int next = cur+i;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Move(next, time+1));
                }
            }
            for (int i = 1; i <= maze[cur] && cur-i >= 1; ++i) {
                int next = cur-i;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Move(next, time+1));
                }
            }
        }
        System.out.println(-1);
    }
}
