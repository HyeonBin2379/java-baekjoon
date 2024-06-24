package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14500 {

    private static int[][] board;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int r, c;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            // 배열의 한 지점을 테트로미노의 시작지점으로 설정, 테트로미노를 만들었을 때의 합의 최대값을 구함
            for (int j = 0; j < c; j++) {
                visited[i][j] = true;
                makeTetromino(i, j, board[i][j], 1);
                // 테트로미노 생성 과정에서 이전에 시작점으로 방문한 지점을 재방문하기 위한 조치
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }

    private static void makeTetromino(int currRow, int currCol, int sum, int step) {
        if (step == 4) {
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 테트로미노는 시작 지점을 기준으로 회전하거나 뒤집은 형태로도 지정 가능
            int nextRow = currRow + dr[i];
            int nextCol = currCol + dc[i];

            // 주어진 범위 내에서 테트로미노 생성 가능 여부 확인
            if (nextRow < 0 || nextRow >= r || nextCol < 0 || nextCol >= c) {
                continue;
            }

            if (!visited[nextRow][nextCol]) {
                // ㅗ자 테트로미노(한붓그리기로 생성 불가)까지 고려한 분기
                if (step == 2) {
                    // 테트로미노의 다음 칸 선택 시 이전에 방문한 지점 외 나머지 중에서 선택
                    visited[nextRow][nextCol] = true;
                    makeTetromino(currRow, currCol, sum + board[nextRow][nextCol], step+1);

                    // 다른 테트로미노 생성 시 지정한 칸을 재활용하기 위한 조치
                    visited[nextRow][nextCol] = false;
                }

                visited[nextRow][nextCol] = true;
                makeTetromino(nextRow, nextCol, sum + board[nextRow][nextCol], step+1);
                visited[nextRow][nextCol] = false;
            }
        }
    }
}
