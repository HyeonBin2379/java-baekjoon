package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exercise13913 {
    private static int[] time;
    private static int[] route;
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        br.close();

        bfs(start, dest);

        int index = dest;
        stack.push(index);
        while (index != start) {
            stack.push(route[index]);
            index = route[index];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(time[dest]);
        System.out.println(sb);
    }

    public static void bfs(int start, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        int[] move = {-1, 1, 2};
        int len = Math.max(start, dest)*2+1;
        time = new int[len];
        route = new int[len];

        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if (now == dest) {
                return;
            }

            for (int nextMove : move) {
                int next = (nextMove != 2) ? now+nextMove : now*nextMove;
                if (next >= 0 && next < len) {
                    if (time[next] == 0 || time[next] >= time[now]+1) {
                        queue.offer(next);
                        time[next] = time[now]+1;
                        route[next] = now;
                    }
                }
            }
        }
    }
}
