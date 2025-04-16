package algorithm.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise5014 {

    private static int f;
    private static int[] dist, moves;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        dist = new int[f+1];
        moves = new int[] {u, -d};
        Arrays.fill(dist, -1);
        bfs(s);
        if (dist[g] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dist[g]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int move : moves) {
                int next = now + move;

                if (next < 1 || next > f) {
                    continue;
                }
                if (dist[next] == -1) {
                    dist[next] = dist[now]+1;
                    queue.offer(next);
                }
            }
        }
    }
}
