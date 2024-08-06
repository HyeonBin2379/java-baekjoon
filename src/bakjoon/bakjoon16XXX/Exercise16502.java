package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise16502 {

    private static final double[][] graph = new double[4][4];
    private static final double[] result = new double[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        while (edge-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0)-'A';
            int to = st.nextToken().charAt(0)-'A';
            double prob = Double.parseDouble(st.nextToken());
            graph[from][to] = prob;
        }

        for (int i = 0; i < 4; i++) {
            dfs(i, 0.25, time);
        }
        Arrays.stream(result).mapToObj(val -> String.format("%.2f", val*100)).forEach(System.out::println);
    }

    private static void dfs(int now, double prob, int time) {
        if (time == 0) {
            result[now] += prob;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (graph[now][i] != 0) {
                dfs(i, prob * graph[now][i], time-1);
            }
        }
    }
}
