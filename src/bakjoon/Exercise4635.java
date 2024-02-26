package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int count = Integer.parseInt(br.readLine());
            if (count == -1) {
                break;
            }

            int[][] moveLog = new int[count][2];
            int sum = 0;
            for (int i = 0; i < count; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                moveLog[i][0] = Integer.parseInt(st.nextToken());
                moveLog[i][1] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    sum = moveLog[i][0]*moveLog[i][1];
                } else {
                    sum += (moveLog[i][1]-moveLog[i-1][1])*moveLog[i][0];
                }
            }
            sb.append(String.format("%d miles\n", sum));
        }
        System.out.print(sb);
    }
}
