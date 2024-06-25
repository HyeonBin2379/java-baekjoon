package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Exercise26536 {

    private static final int[][] move = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testcase; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            board = new int[input[0]+1][input[0]+1];
            IntStream.rangeClosed(1, input[0]).forEach(index -> Arrays.fill(board[index], -1));
            bfs(input);
            sb.append(String.format("Case #%d: %d\n", i, board[input[3]][input[4]])).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int[] input) {
        Queue<Integer[]> queue = new LinkedList<>();
        board[input[1]][input[2]] = 0;
        queue.add(new Integer[]{input[1], input[2]});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 1 || nr > input[0] || nc < 1 || nc > input[0] || board[nr][nc] != -1) {
                    continue;
                }
                board[nr][nc] = board[now[0]][now[1]] + 1;
                queue.add(new Integer[]{nr, nc});
            }
        }
    }
}
