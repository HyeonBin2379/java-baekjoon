package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise23747 {

    private static int r, c;
    private static char[][] map, sight;
    private static final String directions = "UDLR";
    private static final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        sight = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(sight[i], '#');
        }

        st = new StringTokenizer(br.readLine());
        int posR = Integer.parseInt(st.nextToken()) - 1;
        int posC = Integer.parseInt(st.nextToken()) - 1;
        String[] journey = br.readLine().split("");
        for (String cmd : journey) {
            int idx = "UDLR".indexOf(cmd);
            if (idx == -1) {
                ward(posR, posC, map[posR][posC]);
            } else {
                posR += move[idx][0];
                posC += move[idx][1];
            }
        }
        lastPosition(posR, posC);
        IntStream.range(0, r).forEach(idx -> System.out.println(new String(sight[idx])));
    }

    private static void ward(int posR, int posC, char area) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        sight[posR][posC] = '.';
        queue.offer(new Integer[]{posR, posC});

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nr = now[0] + ints[0];
                int nc = now[1] + ints[1];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }
                if (sight[nr][nc] == '#' && map[nr][nc] == area) {
                    sight[nr][nc] = '.';
                    queue.offer(new Integer[]{nr, nc});
                }
            }
        }
    }

    private static void lastPosition(int posR, int posC) {
        sight[posR][posC] = '.';
        for (int[] ints : move) {
            int nr = posR + ints[0];
            int nc = posC + ints[1];

            if (nr < 0 || nr >= r || nc < 0 || nc >= c || sight[nr][nc] == '.') {
                continue;
            }
            sight[nr][nc] = '.';
        }
    }
}
