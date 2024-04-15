package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise9891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rectSize = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            rectSize[i][0] = Math.abs(x2-x1);
            rectSize[i][1] = Math.abs(y2-y1);
            Arrays.sort(rectSize[i]);
        }

        int answer = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if ((rectSize[i][0] < rectSize[j][0] && rectSize[i][1] > rectSize[j][1])
                        || (rectSize[i][0] > rectSize[j][0] && rectSize[i][1] < rectSize[j][1])) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
