package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise27100 {

    private static int s, e, maxValue;
    private static int[] stamp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        stamp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        maxValue = Arrays.stream(stamp).max().getAsInt() * e;

        visited = new boolean[maxValue+1];
        bfs();

        int answer = 0;
        int count = 0;
        for (int i = 1; i <= maxValue; i++) {
            if (visited[i]) {
                answer = Math.max(answer, count+1);
                count++;
            } else {
                count = 0;
            }
        }
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(new Integer[] {0, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[1] < e) {
                for (int i = 0; i < s; i++) {
                    int newValue = now[0] + stamp[i];
                    if (newValue <= maxValue && !visited[newValue]) {
                        visited[newValue] = true;
                        queue.add(new Integer[] {newValue, now[1]+1});
                    }
                }
            }
        }
    }
}
