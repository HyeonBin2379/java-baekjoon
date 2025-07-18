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

public class Exercise6118 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(0, n).forEach(idx -> graph.add(new ArrayList<>()));;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        visited = new int[n+1];
        Arrays.fill(visited, -1);
        bfs();

        int maxLen = 0, answer = 0;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (maxLen < visited[i]) {
                answer = i;
                maxLen = visited[i];
                count = 1;
            } else if (answer != 0 && maxLen == visited[i]) {
                count++;
            }
        }
        System.out.println(answer + " " + maxLen + " " + count);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (visited[next] == -1) {
                    visited[next] = visited[curr]+1;
                    queue.add(next);
                }
            }
        }
    }
}
