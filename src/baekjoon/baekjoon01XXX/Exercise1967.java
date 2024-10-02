package baekjoon.baekjoon01XXX;

import java.io.*;
import java.util.*;

public class Exercise1967 {

    private static ArrayList<Node>[] graph;
    private static class Node {
        int num, len;
        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        graph = new ArrayList[nodeCount +1];
        for (int i = 1; i < nodeCount +1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < nodeCount -1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }
        br.close();

        answer = 0;
        for (int i = 1; i < nodeCount +1; i++) {
            visited = new boolean[nodeCount +1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    public static void dfs(int number, int dist) {
        for (Node next : graph[number]) {
            if (!visited[next.num]) {
                visited[next.num] = true;
                dfs(next.num, dist+next.len);
            }
        }
        answer = Math.max(answer, dist);
    }
}
