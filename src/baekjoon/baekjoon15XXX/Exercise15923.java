package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15923 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] pos = new int[n][2];
        pos[0] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        for (int i = 1; i < n; i++) {
            pos[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            answer += Math.abs(pos[i][0] + pos[i][1] - pos[i-1][0] - pos[i-1][1]);
        }
        answer += Math.abs(pos[n-1][0]+pos[n-1][1] - pos[0][0] - pos[0][1]);
        System.out.println(answer);
    }
}
