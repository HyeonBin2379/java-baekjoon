package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Exercise5427 {

    private static int w, h;
    private static char[][] map;
    private static int[][] fire, escaping;
    private static final int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            Queue<Integer[]> nextRoute = new LinkedList<>();
            Queue<Integer[]> nextBurning = new LinkedList<>();
            map = new char[h][w];
            setBuildingMap();
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    switch (map[i][j]) {
                        case '@' -> {
                            nextRoute.add(new Integer[]{i, j});
                            fire[i][j] = 0;
                        }
                        case '*' -> {
                            nextBurning.add(new Integer[]{i, j});
                            escaping[i][j] = 0;
                        }
                    }
                }
            }
            burning(nextBurning);
            bw.write(escaping(nextRoute) + "\n");
        }
        br.close();
        bw.close();
    }

    private static void setBuildingMap() {
        fire = new int[h][w];
        escaping = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(escaping[i], -1);
        }
    }

    private static void burning(Queue<Integer[]> queue) {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            for (int[] ints : move) {
                int nh = now[0] + ints[0];
                int nw = now[1] + ints[1];

                if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
                    continue;
                }
                if (map[nh][nw] != '#' && fire[nh][nw] == -1) {
                    fire[nh][nw] = fire[now[0]][now[1]] + 1;
                    queue.add(new Integer[]{nh, nw});
                }
            }
        }
    }

    private static String escaping(Queue<Integer[]> queue) {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int time = escaping[now[0]][now[1]] + 1;

            if (now[0] == 0 || now[0] == h-1 || now[1] == 0 || now[1] == w-1) {
                return Integer.toString(time+1);
            }

            for (int[] ints : move) {
                int nh = now[0] + ints[0];
                int nw = now[1] + ints[1];

                if (nh < 0 || nh >= h || nw < 0 || nw >= w || map[nh][nw] == '#') {
                    continue;
                }
                if ((fire[nh][nw] != -1 && fire[nh][nw] <= time) || escaping[nh][nw] != -1) {
                    continue;
                }
                escaping[nh][nw] = time;
                queue.add(new Integer[]{nh, nw});
            }
        }
        return "IMPOSSIBLE";
    }
}
