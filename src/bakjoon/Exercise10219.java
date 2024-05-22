package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            char[][] grill = new char[r][c];
            for (int i = 0; i < r; i++) {
                grill[i] = br.readLine().toCharArray();
                for (int j = c-1; j >= 0; j--) {
                    answer.append(grill[i][j]);
                }
                answer.append("\n");
            }
        }
        System.out.print(answer);
    }
}
