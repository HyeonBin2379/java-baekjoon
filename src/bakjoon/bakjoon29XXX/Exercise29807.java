package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] score = new long[5];
        for (int i = 0; i < count; i++) {
            score[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        long[] sum = new long[3];
        sum[0] = Math.abs(score[0]-score[2]);
        sum[0] *= (score[0] > score[2]) ? 508 : 108;

        sum[1] = Math.abs(score[1]-score[3]);
        sum[1] *= (score[1] > score[3]) ? 212 : 305;

        sum[2] = (count == 5) ? score[4]*707 : 0;
        System.out.println(Arrays.stream(sum).sum() * 4763);
    }
}
