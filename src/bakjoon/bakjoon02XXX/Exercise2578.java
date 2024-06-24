package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2578 {

    private static final int[][] posByNum = new int[25][];
    private static final int[][] bingo = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            bingo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 5; j++) {
                posByNum[bingo[i][j]-1] = new int[]{i, j};
            }
        }

        int[] num = new int[25];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                num[i*5+j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 25; i++) {
            bingo[posByNum[num[i]-1][0]][posByNum[num[i]-1][1]] = 0;
            if (getBingoCount() >= 3) {
                System.out.println(i+1);
                break;
            }
        }
    }

    private static int getBingoCount() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (Arrays.stream(bingo[i]).allMatch(value -> value == 0)) {
                count++;
            }

            int v = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] != 0) {
                    break;
                }
                v++;
            }
            count += (v == 5) ? 1 : 0;
        }

        int d1 = 0, d2 = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                d1++;
            }
            if (bingo[i][4-i] == 0) {
                d2++;
            }
        }
        if (d1 == 5) {
            count++;
        }
        if (d2 == 5) {
            count++;
        }
        return count;
    }
}
