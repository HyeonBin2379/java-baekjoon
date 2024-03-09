package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2160 {
    private static char[][][] pic;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pic = new char[n][5][7];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                pic[i][j] = br.readLine().toCharArray();
            }
        }

        int min = Integer.MAX_VALUE;
        int ans1 = -1, ans2 = -1;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int count = getDiffCount(i, j);
                if (min > count) {
                    min = count;
                    ans1 = i+1;
                    ans2 = j+1;
                }
            }
        }
        System.out.println(ans1 + " " + ans2);
    }

    public static int getDiffCount(int a, int b) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (pic[a][i][j] != pic[b][i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
