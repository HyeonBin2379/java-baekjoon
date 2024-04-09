package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise9455 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] grid = new int[r][c];

            for (int j = 0; j < r; j++) {
                grid[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int answer = 0;
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < r; k++) {
                    if (grid[k][j] == 1) {
                        for (int l = k+1; l < r; l++) {
                            answer += grid[l][j] == 0 ? 1 : 0;
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
