package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2897 {

    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[] result = new int[5];
        for (int i = 0; i < r-1; i++) {
            for (int j = 0; j < c-1; j++) {
                int res = getBreakCnt(i, j);
                if (res != -1) {
                    result[res]++;
                }
            }
        }
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int getBreakCnt(int row, int col) {
        int count = 0;
        for (int i = row; i < row+2; i++) {
            for (int j = col; j < col+2; j++) {
                if (map[i][j] == '#') {
                    return -1;
                } else if (map[i][j] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }
}
