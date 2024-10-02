package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise14562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            bfs(s, t);
        }
    }

    private static void bfs(int start, int target) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{start, target, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[0].equals(now[1])) {
                System.out.println(now[2]);
                return;
            }
            if (now[0] > now[1]) {
                continue;
            }

            queue.offer(new Integer[]{now[0]*2, now[1]+3, now[2]+1});
            queue.offer(new Integer[]{now[0]+1, now[1], now[2]+1});
        }
    }
}
