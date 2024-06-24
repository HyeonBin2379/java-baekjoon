package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Exercise5567 {

    private static final Map<Integer, List<Integer>> graph = new TreeMap<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        setGraph(n);
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n+1];
        findFriend(1, 0);
        System.out.println(IntStream.rangeClosed(2, n).filter(num -> visited[num]).count());
    }

    private static void setGraph(int n) {
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    private static void findFriend(int num, int depth) {
        if (depth == 2) {
            return;
        }
        for (int next : graph.get(num)) {
            visited[next] = true;
            findFriend(next, depth+1);
        }
    }
}
