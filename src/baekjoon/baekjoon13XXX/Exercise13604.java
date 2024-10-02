package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise13604 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int j = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[][] record = new int[r][j];
        int[] score = new int[j];
        for (int i = 0; i < r*j; i++) {
            record[i/j][i%j] = Integer.parseInt(st.nextToken());
            score[i%j] += record[i/j][i%j];
        }

        int max = 0;
        int answer = 0;
        for (int i = j-1; i >= 0; i--) {
            if (score[i] > max) {
                max = Math.max(score[i], max);
                answer = i+1;
            } else if (score[i] == max) {
                answer = Math.max(answer, i+1);
            }
        }
        System.out.println(answer);
    }
}
