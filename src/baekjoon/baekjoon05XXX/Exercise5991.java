package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise5991 {

    private static int n, m;
    private static int[][] graph, visited;
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new int[n][m];
        bfs();
    }

    private static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0] = graph[0][0];
        queue.offer(new Integer[]{0, 0});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            Integer[] next = now.clone();
            int max = 0;

            for (int[] ints : move) {
                Integer[] temp = new Integer[2];
                temp[0] = now[0] + ints[0];
                temp[1] = now[1] + ints[1];

                if (temp[0] < 0 || temp[0] >= n || temp[1] < 0 || temp[1] >= m) {
                    continue;
                }
                if (visited[temp[0]][temp[1]] == 0 && graph[temp[0]][temp[1]] > max) {
                    max = graph[temp[0]][temp[1]];
                    next = temp.clone();
                }
            }

            if (visited[next[0]][next[1]] == 0) {
                visited[next[0]][next[1]] = visited[now[0]][now[1]] + graph[next[0]][next[1]];
                queue.offer(next.clone());
            }
        }
        System.out.println(visited[n-1][m-1]);
    }
}
