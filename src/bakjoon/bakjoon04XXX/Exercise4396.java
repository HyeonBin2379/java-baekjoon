package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4396 {
    private static final int[] ROW = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] COL = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static char[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            field[i] = br.readLine().toCharArray();
        }

        boolean boom = false;
        for (int i = 0; i < size; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                if (input[j] == 'x') {
                    if (field[i][j] == '*') {   // 지뢰 있는 칸 선택 -> 게임오버인 경우
                        boom = true;
                        continue;
                    }
                    field[i][j] = input[j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        char[][] answer = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (field[i][j]) {
                    // 지뢰칸에서는 게임오버되면 지뢰를, 아니면 '.'를 표시
                    case '*' -> answer[i][j] = (boom) ? field[i][j] : '.';
                    case 'x' -> answer[i][j] = countMine(i, j, size);
                    default -> answer[i][j] = '.';
                }
            }
            sb.append(new String(answer[i])).append("\n");
        }
        System.out.print(sb);
    }

    private static char countMine(int i, int j, int size) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int nRow = i + ROW[k];
            int nCol = j + COL[k];

            if (nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) {
                continue;
            }
            if (field[nRow][nCol] == '*') { // 현재 칸 기준 주변의 칸 중 지뢰칸 개수 세기
                count++;
            }
        }
        return (char) ('0'+count);
    }
}
