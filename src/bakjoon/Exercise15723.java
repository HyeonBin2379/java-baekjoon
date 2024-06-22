package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15723 {

    private static final int[][] dist = new int[26][26];
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        setGraph();
        for (int i = 0; i < n; i++) {
            String[] fromTo = br.readLine().split(" is ");
            int from = fromTo[0].charAt(0) - 'a';
            int to = fromTo[1].charAt(0) - 'a';
            dist[from][to] = 1;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] fromTo = br.readLine().split(" is ");
            int from = fromTo[0].charAt(0) - 'a';
            int to = fromTo[1].charAt(0) - 'a';
            System.out.println(dist[from][to] != INF ? "T" : "F");
        }
    }

    private static void setGraph() {
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
    }
}
