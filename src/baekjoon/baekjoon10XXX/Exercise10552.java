package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise10552 {

    private static boolean[] visited;
    private static final Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        IntStream.rangeClosed(1, m).forEach(i -> graph.put(i, new ArrayList<>()));
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int dislike = Integer.parseInt(st.nextToken());
            graph.get(dislike).add(like);
        }

        visited = new boolean[m+1];
        dfs(p, m);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (graph.get(now).isEmpty()) {
                System.out.println(count);
                return;
            }
            int next = graph.get(now).get(0);
            if (!visited[next]) {
                queue.offer(next);
                visited[next] = true;
                count++;
            }
        }
        System.out.println(-1);
    }

    private static void dfs(int start, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] depth = new int[n+1];
        visited[start] = true;
        stack.push(start);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            if (graph.get(now).isEmpty()) {
                System.out.println(depth[now]);
                return;
            }
            int next = graph.get(now).get(0);
            if (!visited[next]) {
                stack.push(next);
                visited[next] = true;
                depth[next] = depth[now]+1;
            }
        }
        System.out.println(-1);
    }
}
