package algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise24480 {

    private static final List<List<Integer>> graph = new ArrayList<>();

    private static int count = 1;
    private static int[] answer;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(0, n).forEach(value -> graph.add(new ArrayList<>()));
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        answer = new int[n+1];
        visited = new boolean[n+1];
        visited[r] = true;
        dfs(r);
        IntStream.rangeClosed(1, n).map(idx -> answer[idx]).forEach(System.out::println);
    }

    private static void dfs(int start) {
        answer[start] = count;
        visited[start] = true;

        graph.get(start).sort(Comparator.reverseOrder());
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}
