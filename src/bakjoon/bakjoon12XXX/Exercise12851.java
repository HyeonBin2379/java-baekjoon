package bakjoon.bakjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise12851 {

    private static int count = 0;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        br.close();

        bfs(start, dest);
        System.out.println(result);
        System.out.println(count);
    }

    public static void bfs(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        int len = Math.max(start, dest)*2+1;
        int[] visited = new int[len];
        int[] move = {-1, 1, 2};
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if (result < visited[now]) {
                return;
            }
            else if (now == dest) {
                result = visited[now];
                count++;
            }

            for (int nextMove : move) {
                int next = (nextMove != 2) ? now+nextMove : now*nextMove;

                if (next >= 0 && next < len) {
                    if (visited[next] == 0 || visited[next] >= visited[now]+1) {
                        visited[next] = visited[now]+1;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}
