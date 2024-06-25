package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Exercise6492 {

    private static final int INF = 1000000000;
    private static Map<String, Integer> wareNum;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).filter(s -> !s.isEmpty()).mapToInt(Integer::parseInt).toArray();
            setCode(input[0], br.readLine().split(" "));
            setGraph(input[0]);
            for (int j = 0; j < input[1]; j++) {
                String[] code = br.readLine().split(" ");
                dist[wareNum.get(code[0])][wareNum.get(code[1])] = 1;
                dist[wareNum.get(code[1])][wareNum.get(code[0])] = 1;
            }

            calculateDistance(input[0]);

            sb.append(String.format("DATA SET %d\n\n", i));
            for (int j = 0; j < input[2]; j++) {
                String[] data = Arrays.stream(br.readLine().split(" ")).filter(s -> !s.isEmpty()).toArray(String[]::new);
                int distance = dist[wareNum.get(data[1])][wareNum.get(data[2])];
                if (distance == INF) {
                    sb.append("NO SHIPMENT POSSIBLE\n");
                } else {
                    sb.append(String.format("$%d\n", 100*Integer.parseInt(data[0])*distance));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void setCode(int size, String[] wareCode) {
        wareNum = new LinkedHashMap<>();
        IntStream.rangeClosed(1, size).forEach(index -> wareNum.put(wareCode[index-1], index));
    }
    private static void setGraph(int size) {
        dist = new int[size+1][size+1];
        IntStream.rangeClosed(1, size).forEach(i -> {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        });
    }

    private static void calculateDistance(int size) {
        for (int k = 1; k <= size; k++) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
                }
            }
        }
    }
}
