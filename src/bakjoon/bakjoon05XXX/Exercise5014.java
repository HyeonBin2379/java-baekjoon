package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise5014 {

    private static int[] visited;
    private static int f, u, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int[f+1];
        int count = bfs(s, g);
        System.out.println(count < 0 ? "use the stairs" : count);
    }

    private static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            int[] move = {now+u, now-d};

            if (now == end) {
                return visited[now]-1;
            }

            for (int i = 0; i < 2; i++) {
                int next = move[i];

                if (next < 1 || next > f || visited[next] != 0) {
                    continue;
                }
                visited[next] = visited[now]+1;
                queue.add(next);
            }
        }
        return -1;
    }
}
