package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercise1730 {

    private static final Map<Character, Integer[]> direction = new HashMap<>(Map.of(
            'D', new Integer[]{1, 0},
            'U', new Integer[]{-1, 0},
            'R', new Integer[]{0, 1},
            'L', new Integer[]{0, -1}
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], '.');
        }

        char[] cmd = br.readLine().toCharArray();
        Integer[] now = {0, 0};

        for (char dir : cmd) {
            Integer[] nextDir = direction.get(dir);
            Integer[] next = {now[0] + nextDir[0], now[1] + nextDir[1]};

            if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n) {
                continue;
            }

            char trace = (dir == 'U' || dir == 'D') ? '|' : '-';
            if (map[now[0]][now[1]] == '|' && (dir == 'R' || dir == 'L')
                    || map[now[0]][now[1]] == '-' && (dir == 'D' || dir == 'U')) {
                map[now[0]][now[1]] = '+';
            } else if (map[now[0]][now[1]] == '.') {
                map[now[0]][now[1]] = trace;
            }

            if (map[next[0]][next[1]] == '|' && (dir == 'R' || dir == 'L')
                    || map[next[0]][next[1]] == '-' && (dir == 'D' || dir == 'U')) {
                map[next[0]][next[1]] = '+';
            } else if (map[next[0]][next[1]] == '.'){
                map[next[0]][next[1]] = trace;
            }
            now = next.clone();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(new String(map[i]));
        }
    }
}