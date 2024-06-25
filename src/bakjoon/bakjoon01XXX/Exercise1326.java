package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1326 {

    private static int n;
    private static int[] num;
    private static boolean[] visited;
    private static class Frog {
        int location, jumpTime;

        public Frog(int location, int jumpTime) {
            this.location = location;
            this.jumpTime = jumpTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n+1];
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        bfs(start, end);
    }

    private static void bfs(int start, int end) {
        Queue<Frog> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new Frog(start, 0));

        while (!queue.isEmpty()) {
            Frog now = queue.poll();

            if (now.location == end) {
                System.out.println(now.jumpTime);
                return;
            }

            for (int i = 1; now.location + (i*num[now.location]) <= n; ++i) {
                int next = now.location + (i*num[now.location]);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Frog(next, now.jumpTime+1));
                }
            }
            for (int i = 1; now.location-(i*num[now.location]) >= 1; ++i) {
                int next = now.location-(i*num[now.location]);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Frog(next, now.jumpTime+1));
                }
            }
        }
        System.out.println(-1);
    }
}
