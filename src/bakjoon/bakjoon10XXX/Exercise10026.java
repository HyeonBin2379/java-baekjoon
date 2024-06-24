package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10026 {
    private static int size;
    private static char[][] pixel;
    private static boolean[][] visited;
    private static final int[][] move = {{0,-1}, {0,1}, {-1,0}, {1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        pixel = new char[size][size];
        for (int i = 0; i < size; i++) {
            pixel[i] = br.readLine().toCharArray();
        }
        br.close();

        int notCount = 0;
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, pixel[i][j]);
                    notCount++;
                }
            }
        }

        int count = 0;
        visited = new boolean[size][size];
        colorBlinded();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, pixel[i][j]);
                    count++;
                }
            }
        }
        System.out.println(notCount);
        System.out.println(count);
    }

    public static void colorBlinded() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pixel[i][j] = (pixel[i][j] == 'G') ? 'R' : pixel[i][j];
            }
        }
    }
    public static void dfs(int i, int j, char color) {
        if (isValidRange(i, j) && !visited[i][j] && pixel[i][j] == color) {
            visited[i][j] = true;
            for (int[] nextMove : move) {
                int ni = i + nextMove[0];
                int nj = j + nextMove[1];
                dfs(ni, nj, color);
            }
        }
    }
    private static boolean isValidRange(int i, int j) {
        return i >= 0 && i < size && j >= 0 && j < size;
    }
}
