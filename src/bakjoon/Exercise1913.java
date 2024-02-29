package bakjoon;

import java.util.Scanner;

public class Exercise1913 {
    private static final int[] dr = {1, 0, -1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(sc.nextLine());
        int target = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[size][size];

        int[] pos = {0, 0};
        int s_row = 0, s_col = 0, dist = 0;
        for (int j = size*size; j > 0; j--) {
            arr[s_row][s_col] = j;
            if (target == j) {
                pos[0] = s_row+1;
                pos[1] = s_col+1;
            }

            s_row += dr[dist % 4];
            s_col += dc[dist % 4];
            if (s_row < 0 || s_col < 0 || s_row >= size || s_col >= size || arr[s_row][s_col] != 0) {
                s_row += (dr[(dist+1) % 4] - dr[dist]);
                s_col += (dc[(dist+1) % 4] - dc[dist]);
                dist = (dist + 1) % 4;
            }
        }

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                sb.append(arr[j][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        System.out.println(pos[0] + " " + pos[1]);
    }
}
