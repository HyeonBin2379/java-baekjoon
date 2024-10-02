package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise21771 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] total = new char[row][col];

        st = new StringTokenizer(br.readLine());
        int g_row = Integer.parseInt(st.nextToken());
        int g_col = Integer.parseInt(st.nextToken());
        int p_row = Integer.parseInt(st.nextToken());
        int p_col = Integer.parseInt(st.nextToken());

        int pillow = 0;
        for (int i = 0; i < row; i++) {
            total[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (total[i][j] == 'P') {
                    pillow++;
                }
            }
        }
        System.out.println(pillow == p_row*p_col ? 0 : 1);
    }
}
