package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Exercise13549 {
    private static int[] distance;
    private static final int[] move = {0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        br.close();

        distance = new int[300000];
        bfs(start, end);
        System.out.println(distance[end]);
    }

    public static void bfs(int start, int end) {
        LinkedList<Integer> queue = new LinkedList<>();
        Arrays.fill(distance, -1);
        distance[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) {
                return;
            }
            for (int nextMove : move) {
                int next = (nextMove == 0) ? now*2 : now+nextMove;
                if (0 <= next && next <= 100000 && distance[next] == -1) {
                    if (next == now*2) {
                        queue.addFirst(next);
                        distance[next] = distance[now];
                    } else {
                        queue.add(next);
                        distance[next] = distance[now]+1;
                    }
                }
            }
        }
    }
}
