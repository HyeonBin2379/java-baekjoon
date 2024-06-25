package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise14248 {

    private static int n;
    private static int[] bridge;
    private static boolean[] visited;
    private static final int[] move = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        bridge = new int[n+1];
        IntStream.rangeClosed(1, n).forEach(i -> bridge[i] = Integer.parseInt(st.nextToken()));
        int start = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        bfs(start);
        System.out.println(IntStream.rangeClosed(1, n).filter(i -> visited[i]).count());
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int nextMove : move) {
                int next = now + bridge[now]*nextMove;
                if (next < 1 || next > n || visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(next);
            }
        }
    }
}
