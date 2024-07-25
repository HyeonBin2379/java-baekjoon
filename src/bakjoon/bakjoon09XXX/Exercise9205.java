package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise9205 {

    private static int n;
    private static boolean[] visited;
    private static Integer[][] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            n = Integer.parseInt(br.readLine());
            Integer[] home = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            pos = new Integer[n][];
            for (int i = 0; i < pos.length; i++) {
                pos[i] = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            }
            Integer[] dest = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

            visited = new boolean[n];
            if (canBeHappy(home, dest)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean canBeHappy(Integer[] home, Integer[] dest) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(home.clone());

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();   // 현위치

            // 현위치에서 목적지까지의 거리
            if (Math.abs(now[0]-dest[0]) + Math.abs(now[1]-dest[1]) <= 1000) {
                return true;
            }
            for (int i = 0; i < n; i++) {
                // 현위치에서 시작점까지의 거리
                if (!visited[i] && Math.abs(pos[i][0]-now[0]) + Math.abs(pos[i][1]-now[1]) <= 1000) {
                    visited[i] = true;
                    queue.offer(pos[i].clone());
                }
            }
        }
        return false;
    }
}
