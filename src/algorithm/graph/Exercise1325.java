package algorithm.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise1325 {

    static class Computer {
        int index;
        List<Computer> adj;

        public Computer(int idx) {
            this.index = idx;
            this.adj = new ArrayList<>();
        }
    }

    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Computer[] graph = new Computer[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new Computer(i);
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].adj.add(graph[a]);
        }
        br.close();

        int[] hacked = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                int now = stack.pop();
                if (visited[now]) {
                    continue;
                }
                visited[i] = true;

                for (Computer next : graph[now].adj) {
                    if (visited[next.index]) {
                        continue;
                    }
                    stack.push(next.index);
                    hacked[i]++;
                }
            }
            max = Math.max(hacked[i], max);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hacked[i] == max) {
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
