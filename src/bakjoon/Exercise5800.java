package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exercise5800 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Integer[] score = new Integer[n];
            for (int j = 0; j < n; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(score, Comparator.reverseOrder());

            int maxGap = 0;
            for (int j = 1; j < n; j++) {
                maxGap = Math.max(score[j-1]-score[j], maxGap);
            }
            sb.append(String.format("Class %d\n", i));
            sb.append(String.format("Max %d, Min %d, Largest gap %d\n", score[0], score[n-1], maxGap));
        }
        System.out.print(sb);
    }
}
