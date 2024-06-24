package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2098 {
    private static int[][] weight;
    private static int[][] distance;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        weight = new int[size][size];
        distance = new int[size][(1 << size)-1];
        for (int i = 0; i < size; i++) {
            weight[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(distance[i], -1);
        }
        br.close();
        System.out.println(tsp(0, 1));
    }

    public static int tsp(int city, int visited) {
        if (visited == ((1 << size) - 1)) {
            return (weight[city][0] == 0) ? 1000000000 : weight[city][0];
        }
        if (distance[city][visited] != -1) {
            return distance[city][visited];
        }
        distance[city][visited] = 1000000000;
        for (int i = 0; i < size; i++) {
            int next = visited | (1 << i);
            if ((visited & (1 << i)) == 0 && weight[city][i] != 0) {
                distance[city][visited] = Math.min(distance[city][visited], tsp(i, next) + weight[city][i]);
            }
        }
        return distance[city][visited];
    }
}
