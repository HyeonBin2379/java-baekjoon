package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8073 {

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        for (int i = 0; i < size; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (isNeighbor(i, j)) {
                    sb.append(String.format("%d %d\n", i+1, j+1));
                }
            }
        }
        System.out.print(sb);
    }

    private static boolean isNeighbor(int start, int end) {
        for (int i = 0; i < graph.length; i++) {
            if (i == start || i == end) {
                continue;
            }
            if (graph[start][end] == graph[start][i] + graph[i][end]) {
                return false;
            }
        }
        return true;
    }
}
