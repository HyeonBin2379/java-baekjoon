package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise7562 {
    private static int[][] chessBoard;
    private static boolean[][] visited;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            size = Integer.parseInt(br.readLine());
            chessBoard = new int[size][size];
            visited = new boolean[size][size];

            int[][] startToEnd = new int[2][2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                startToEnd[j][0] = Integer.parseInt(st.nextToken());
                startToEnd[j][1] = Integer.parseInt(st.nextToken());
            }
            bfs(startToEnd);
            sb.append(chessBoard[startToEnd[1][0]][startToEnd[1][1]]).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    public static void bfs(int[][] startToEnd) {
        Queue<Integer[]> queue = new LinkedList<>();
        int[][] move = {{2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}};
        int[] start = startToEnd[0];

        queue.offer(new Integer[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] direction : move) {
                int x = now[0]+direction[0];
                int y = now[1]+direction[1];

                if (x >= 0 && x < size && y >= 0 && y < size) {
                    if (!visited[x][y]) {
                        queue.offer(new Integer[]{x, y});
                        chessBoard[x][y] = chessBoard[now[0]][now[1]]+1;
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
