package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise3023 {

    private static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        result = new char[r*2][c*2];
        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                result[i][j] = input.charAt(j);
            }
        }
        int[] error = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(operand -> operand-1)
                .toArray();
        setPattern(r, c);
        setError(error[0], error[1]);
        for (char[] chars : result) {
            System.out.println(new String(chars));
        }
    }

    private static void setPattern(int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = c; j < 2*c; j++) {
                result[i][j] = result[i][(c-1)- (j-c)];
            }
        }
        for (int i = r; i < 2 * r; i++) {
            if (2 * c >= 0) {
                System.arraycopy(result[(r - 1) - (i - r)], 0, result[i], 0, 2 * c);
            }
        }
    }

    private static void setError(int r, int c) {
        result[r][c] = (result[r][c] == '#') ? '.' : '#';
    }
}
