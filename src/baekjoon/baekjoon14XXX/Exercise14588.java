package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise14588 {

    private static final int INF = 987654321;
    private static int[][] relation, line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        line = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            line[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        initGraph(n);
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    relation[i][j] = Math.min(relation[i][k] + relation[k][j], relation[i][j]);
                }
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(relation[a][b] == INF ? -1 : relation[a][b]);
        }
    }

    private static void initGraph(int n) {
        relation = new int[n+1][n+1];
        IntStream.rangeClosed(1, n).forEach(i -> Arrays.fill(relation[i], INF));
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (checkInRange(i, j)) {
                    relation[i][j] = 1;
                    relation[j][i] = 1;
                }
            }
        }
    }

    private static boolean checkInRange(int lineNum1, int lineNum2) {
        int[][] friend = {line[lineNum1].clone(), line[lineNum2].clone()};
        for (int i = 0; i < friend[0].length; i++) {
            for (int j = 0; j < friend[1].length; j++) {
                if (friend[i][j] >= friend[(i+1) % 2][0] && friend[i][j] <= friend[(i+1) % 2][1]) {
                    return true;
                }
            }
        }
        return false;
    }
}