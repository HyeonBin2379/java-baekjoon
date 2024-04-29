package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3035 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int zr = Integer.parseInt(st.nextToken());
        int zc = Integer.parseInt(st.nextToken());

        char[][] pattern = new char[r][c];
        for (int i = 0; i < r; i++) {
            pattern[i] = br.readLine().toCharArray();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < r; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < c; j++) {
                line.append(String.valueOf(pattern[i][j]).repeat(zc));
            }
            line.append("\n");
            result.append(line.toString().repeat(zr));
        }
        System.out.print(result);
    }
}
