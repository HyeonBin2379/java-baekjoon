package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1325 {

    static class Computer {
        int index;
        List<Computer> adj;

        public Computer(int idx) {
            this.index = idx;
            this.adj = new ArrayList<>();
        }
    }

    private static Computer[] comps;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        comps = new Computer[n];
        for (int i = 0; i < n; i++) {
            comps[i] = new Computer(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            comps[b].adj.add(comps[a]);
        }

        answer = new int[n];
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i);
        }

        int max = Arrays.stream(answer).parallel().max().getAsInt();
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, n).filter(index -> answer[index-1] == max).forEach(index -> sb.append(index).append(" "));
        System.out.println(sb);
    }

    public static void dfs(int root, int now) {
        if (comps[now].adj.isEmpty()) {
            return;
        }
        for (Computer c : comps[now].adj) {
            if (!visited[c.index]) {
                visited[c.index] = true;
                dfs(root, c.index);
                answer[root]++;
            }
        }
    }
}
