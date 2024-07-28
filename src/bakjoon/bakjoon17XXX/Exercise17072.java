package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise17072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] rgb = new int[n][3 * m];
        char[][] answer = new char[n][m];
        for (int i = 0; i < n; i++) {
            rgb[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < rgb[i].length; j += 3) {
                int intensity = 2126* rgb[i][j] + 7152* rgb[i][j+1] + 722* rgb[i][j+2];
                answer[i][j/3] = getChar(intensity);
            }
            bw.write(new String(answer[i]) + "\n");
        }
        br.close();
        bw.close();
    }

    private static char getChar(int intensity) {
        if (intensity < 510000) {
            return '#';
        } else if (intensity < 1020000) {
            return 'o';
        } else if (intensity < 1530000) {
            return '+';
        } else if (intensity < 2040000) {
            return '-';
        } else {
            return '.';
        }
    }
}
