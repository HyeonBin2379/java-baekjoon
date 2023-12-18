package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise11404 {
    private static int[][] city;
    private static int[][] cost;
    private static int nodeCount;
    private static final int MAX_LIMIT = 10000000;

    public static void main(String[] args) throws IOException {
        inputValues();
        initCost();
        floyd();
        printResult();
    }

    public static void inputValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());

        StringTokenizer st;
        city = new int[nodeCount+1][nodeCount+1];
        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int expense = Integer.parseInt(st.nextToken());
            city[from][to] = (city[from][to] == 0) ? expense : Math.min(expense, city[from][to]);
        }
        br.close();
    }
    public static void initCost() {
        cost = new int[nodeCount+1][nodeCount+1];
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (i == j) {
                    cost[i][j] = 0;
                } else if (city[i][j] > 0) {
                    cost[i][j] = city[i][j];
                } else {
                    cost[i][j] = MAX_LIMIT;
                }
            }
        }
    }
    public static void floyd() {
        for (int k = 1; k <= nodeCount; k++) {
            for (int i = 1; i <= nodeCount; i++) {
                for (int j = 1; j <= nodeCount; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
                }
            }
        }
    }
    public static void printResult() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = 1; j <= nodeCount; j++) {
                if (cost[i][j] == MAX_LIMIT) {
                    bw.write(0 + " ");
                } else {
                    bw.write(cost[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}