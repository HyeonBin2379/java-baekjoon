package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalSec = 0;
        for (int i = 0; i < 3; i++) {
            totalSec += time[i]*Math.pow(60, 2-i);
        }

        int query = Integer.parseInt(br.readLine());
        for (int i = 0; i < query; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int sec;
            switch (mode) {
                case 1 -> {
                    sec = Integer.parseInt(st.nextToken());
                    totalSec = (totalSec + sec) % 86400;
                }
                case 2 -> {
                    sec = Integer.parseInt(st.nextToken());
                    totalSec = (totalSec - sec) % 86400;
                    if (totalSec < 0) {
                        totalSec += 86400;
                    }
                }
                case 3 -> {
                    int hour = totalSec / 3600;
                    int min = (totalSec % 3600) / 60;
                    sb.append(String.format("%d %d %d\n", hour, min, totalSec % 60));
                }
            }
        }
        System.out.print(sb);
    }
}
