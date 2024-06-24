package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise2210 {
    private static final int[][] numberBoard = new int[5][5];
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Set<String> number = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            numberBoard[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String num = "";
                dfs(i, j, num);
            }
        }
        System.out.println(number.size());
    }

    public static void dfs(int x, int y, String num) {
        if (num.length() == 6) {
            number.add(num);
            return;
        }

        for (int[] direction : move) {
            int nx = x + direction[0];
            int ny = y + direction[1];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                dfs(nx, ny, num+numberBoard[nx][ny]);
            }
        }
    }
}
