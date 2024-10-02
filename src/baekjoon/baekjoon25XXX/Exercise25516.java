package baekjoon.baekjoon25XXX;

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

public class Exercise25516 {

    private static int n, k;
    private static int[] apple, visited;
    private static final List<List<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, n-1).forEach(i -> tree.add(new ArrayList<>()));

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree.get(parent).add(child);
        }
        apple = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited = IntStream.rangeClosed(0, n-1).map(i -> -1).toArray();
        visited[0] = 0;
        queue.add(0);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : tree.get(now)) {
                if (visited[next] == -1) {
                    visited[next] = visited[now]+1;
                    queue.add(next);
                }
            }
        }

        System.out.println(IntStream.rangeClosed(0, n-1)
                .filter(i -> visited[i] >= 0 && visited[i] <= k)
                .map(i -> apple[i])
                .sum());
    }
}
