package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n-1; i >= 1; i--) {
            if (score[i] <= score[i-1]) {
                int diff = score[i-1]-score[i]+1;
                score[i-1] -= diff;
                answer += diff;
            }
        }
        System.out.println(answer);
    }
}
