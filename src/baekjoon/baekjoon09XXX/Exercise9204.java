package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9204 {

    private static int sCol, sRow, eCol, eRow;
    private static boolean[][] map;
    private static final int[][] move = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sCol = st.nextToken().charAt(0)-'A'+1;
            sRow = 9-Integer.parseInt(st.nextToken());
            eCol = st.nextToken().charAt(0)-'A'+1;
            eRow = 9-Integer.parseInt(st.nextToken());
            map = new boolean[9][9];
            if ((sRow != eRow || sCol != eCol)
                    && (Math.abs(sRow-eRow) + Math.abs(sCol-eCol)) % 2 == 1) {
                System.out.println("Impossible");
                continue;
            }
            canMove();
        }
    }

    private static void canMove() {
        if (sRow == eRow && sCol == eCol) {
            System.out.println(0 + " " + (char) (sCol + 'A' - 1) + " " + (9-sRow));
            return;
        }
        if (first(eRow, eCol)) {
            System.out.print("1 ");
            System.out.print((char) (sCol + 'A' - 1) + " " + (9-sRow) + " ");
            System.out.println((char)(eCol+ 'A' - 1) + " " + (9-eRow) + " ");
            return;
        }
        System.out.print("2 ");
        System.out.print((char) (sCol + 'A' - 1) + " " + (9-sRow) + " ");
        second(sRow, sCol);
        System.out.println((char)(eCol+ 'A' - 1) + " " + (9-eRow) + " ");
    }

    private static boolean isInRange(int r, int c) {
        return 1 <= r && r <= 8 && 1 <= c && c <= 8;
    }
    private static boolean first(int r, int c) {
        for (int[] ints : move) {
            int nr = r;
            int nc = c;
            while (isInRange(nr+ints[0], nc+ints[1])) {
                nr += ints[0];
                nc += ints[1];
                map[nr][nc] = true;
            }
        }
        return map[sRow][sCol];
    }

    private static void second(int r, int c) {
        for (int[] ints : move) {
            int nr = r;
            int nc = c;
            while (isInRange(nr+ints[0], nc+ints[1])) {
                nr += ints[0];
                nc += ints[1];
                if (map[nr][nc]) {
                    System.out.print((char) (nc + 'A' - 1) + " " + (9 - nr) + " ");
                    return;
                }
            }
        }
    }
}
