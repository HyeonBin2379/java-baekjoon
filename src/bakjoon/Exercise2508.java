package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char[][] box = new char[r][c];
            int answer = 0;
            for (int j = 0; j < r; j++) {
                box[j] = br.readLine().toCharArray();
                for (int k = 0; k < c-2; k++) {
                    if (box[j][k] == '>' && box[j][k+1] == 'o' && box[j][k+2] == '<') {
                        answer++;
                    }
                }
            }

            for (int j = 0; j < c; j++) {
                for (int k = 0; k < r-2; k ++) {
                    if (box[k][j] == 'v' && box[k+1][j] == 'o' && box[k+2][j] == '^') {
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
