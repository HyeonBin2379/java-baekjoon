package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise17197 {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static final List<Cow> cows = new ArrayList<>();

    private static boolean[] visited;
    private static int minX, minY, maxX, maxY;
    private static class Cow {
        int x, y;
        Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows.add(new Cow(x, y));
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = Integer.MAX_VALUE;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                minX = Integer.MAX_VALUE;
                maxX = Integer.MIN_VALUE;
                minY = Integer.MAX_VALUE;
                maxY = Integer.MIN_VALUE;

                dfs(i);

                // 최소 둘레 갱신
                int len = 2 * ((maxX - minX) + (maxY - minY));
                answer = Math.min(answer, len);
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int node) {
        visited[node] = true;
        minX = Math.min(minX, cows.get(node).x);
        maxX = Math.max(maxX, cows.get(node).x);
        minY = Math.min(minY, cows.get(node).y);
        maxY = Math.max(maxY, cows.get(node).y);

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
