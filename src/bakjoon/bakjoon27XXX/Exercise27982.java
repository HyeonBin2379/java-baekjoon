package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise27982 {

    private static final int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    private static boolean[][][] space;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        space = new boolean[n][n][n];
        int[][] position = new int[m][3];
        for (int i = 0; i < m; i++) {
            position[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)-1).toArray();
            space[position[i][0]][position[i][1]][position[i][2]] = true;
        }
        System.out.println(IntStream.range(0, m)
                .filter(i -> isMatched(position[i], n))
                .count());
    }

    private static boolean isMatched(int[] position, int size) {
        for (int[] ints : move) {
            int[] next = new int[3];

            for (int i = 0; i < 3; i++) {
                next[i] = position[i] + ints[i];
            }

            if (isInRange(next, size) || !space[next[0]][next[1]][next[2]]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInRange(int[] next, int size) {
        return next[0] < 0 || next[0] >= size
                || next[1] < 0 || next[1] >= size
                || next[2] < 0 || next[2] >= size;
    }
}
