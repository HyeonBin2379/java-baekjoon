package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] tic = new char[n][n];
        for (int i = 0; i < n; i++) {
            tic[i] = br.readLine().toCharArray();
        }

        if (n < 3) {
            System.out.println("ongoing");
            return;
        }

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                if (tic[i][j] != '.' && tic[i][j] == tic[i+1][j+1] && tic[i][j] == tic[i+2][j+2]) {
                    System.out.println(tic[i][j]);
                    return;
                }
                if (tic[i][n-j-1] != '.' && tic[i][n-j-1] == tic[i+1][n-j-2] && tic[i][n-j-1] == tic[i+2][n-j-3]) {
                    System.out.println(tic[i][n-j-1]);
                    return;
                }
            }
        }

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n; j++) {
                if (tic[i][j] != '.' && tic[i][j] == tic[i+1][j] && tic[i][j] == tic[i+2][j]) {
                    System.out.println(tic[i][j]);
                    return;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-2; j++) {
                if (tic[i][j] != '.' && tic[i][j] == tic[i][j+1] && tic[i][j] == tic[i][j+2]) {
                    System.out.println(tic[i][j]);
                    return;
                }
            }
        }
        System.out.println("ongoing");
    }
}
