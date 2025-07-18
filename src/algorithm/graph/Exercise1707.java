package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1707 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.clear();

            IntStream.rangeClosed(0, v).forEach(idx -> graph.add(new ArrayList<>()));
            while (e-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            color = new int[v+1];
            Arrays.fill(color, -1);
            printResult(v);
        }
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        color[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (color[next] == -1) {
                    color[next] = (color[cur] == 0) ? 1 : 0;
                    queue.offer(next);
                } else if (color[next] == color[cur]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printResult(int v) {
        for (int i = 1; i <= v; i++) {
            if (color[i] == -1 && !bfs(i)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
