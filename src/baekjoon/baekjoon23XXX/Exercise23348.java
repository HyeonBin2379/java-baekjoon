package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise23348 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] difficulty = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    score[i] += Integer.parseInt(st.nextToken())*difficulty[k];
                }
            }
        }
        System.out.println(Arrays.stream(score).max().getAsInt());
    }
}
