package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise28356 {

    private static int n, m;
    private static int max = 0;
    private static int[][] examType;
    private static final int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        examType = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                setValue(i, j);
            }
        }

        bw.write(max + "\n");
        for (int i = 0; i < n; i++) {
            bw.write(Arrays.stream(examType[i])
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(" "))+"\n");
        }
        br.close();
        bw.close();
    }

    private static void setValue(int r, int c) {
        int temp = 1;
        while (hasSameType(r, c, temp)) {
            temp++;
        }
        max = Math.max(temp, max);
        examType[r][c] = temp;
    }

    private static boolean hasSameType(int r, int c, int val) {
        for (int[] ints : move) {
            int nr = r + ints[0];
            int nc = c + ints[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                continue;
            }
            if (examType[nr][nc] == val) {
                return true;
            }
        }
        return false;
    }
}
