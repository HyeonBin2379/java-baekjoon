package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise15683 {

    private static final int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final List<Integer[]> cctv = new ArrayList<>();

    private static int n, m, answer;
    private static int[][] map, scanned;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                // 사무실 각 칸의 정보 입력
                map[i][j] = Integer.parseInt(st.nextToken());

                // cctv의 위치와 빈 공간의 개수 파악
                if (map[i][j] == 0) {
                    answer++;
                } else if (map[i][j] != 6) {
                    cctv.add(new Integer[]{i, j});
                }
            }
        }

        scanned = new int[n][m];
        for (int tmp = 0; tmp < (1 << (2*cctv.size())); tmp++) {
            // cctv가 볼 수 있는 영역을 표기하기 위한 복사본 생성
            IntStream.range(0, n).forEach(idx -> scanned[idx] = map[idx].clone());

            int brute = tmp;
            for (Integer[] integers : cctv) {
                // 현재 cctv의 위치
                int r = integers[0];
                int c = integers[1];

                // 현재 cctv의 촬영 방향을 지정
                int dir = brute % 4;
                brute /= 4;

                // 현재 cctv의 종류에 따른 촬영 가능 범위 체크
                switch (map[r][c]) {
                    case 1 -> watch(r, c, dir);
                    case 2 -> {
                        watch(r, c, dir);
                        watch(r, c, dir + 2);
                    }
                    case 3, 4, 5 -> IntStream.rangeClosed(0, map[r][c]-2).forEach(i -> watch(r, c, dir+i));
                }

                // cctv의 사각지대에 해당하는 칸 개수의 최소값 구하기
                int cnt = (int) Arrays.stream(scanned).flatMapToInt(Arrays::stream).filter(val -> val == 0).count();
                answer = Math.min(cnt, answer);
            }
        }
        System.out.println(answer);
    }

    private static void watch(int r, int c, int dir) {
        // 현재 cctv의, 지정한 방향에서의 촬영 가능 범위 표시
        dir %= 4;
        while (true) {
            r += moves[dir][0];
            c += moves[dir][1];

            if (!isInRange(r, c) || scanned[r][c] == 6) {
                return;
            }
            if (scanned[r][c] != 0) {
                continue;
            }
            scanned[r][c] = -1;
        }
    }

    private static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}
