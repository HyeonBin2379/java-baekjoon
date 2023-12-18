package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise1707 {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] check;
    private static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());

            check = new int[nodeCount+1];
            visited = new boolean[nodeCount+1];
            graph = new ArrayList[nodeCount+1];
            for (int j = 1; j < nodeCount+1; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < edgeCount; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                graph[to].add(from);
            }

            isEven = true;
            /*
            for (int j = 1; j < nodeCount+1; j++) {
                if (!isEven) {
                    break;
                }
                //dfs(j);
            }*/
            bfs();
            sb.append((isEven) ? "YES" : "NO").append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    public static void dfs(int now) {
        visited[now] = true;
        for (Integer next : graph[now]) {
            if (!visited[next]) {
                check[next] = (check[now]+1) % 2;
                dfs(next);
            } else if (check[next] == check[now]){
                if (check[next] == check[now]) {
                    isEven = false;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < graph.length; i++) {
            if (check[i] == 0) {
                queue.offer(i);
                check[i] = 1;
            }

            while (!queue.isEmpty()) {
                Integer now = queue.poll();
                for (Integer next : graph[now]) {
                    if (check[next] == 0) {
                        queue.offer(next);
                        check[next] = check[now]*(-1);
                    } else if (check[next] == check[now]) {
                        isEven = false;
                        return;
                    }
                }
            }
        }
    }
}