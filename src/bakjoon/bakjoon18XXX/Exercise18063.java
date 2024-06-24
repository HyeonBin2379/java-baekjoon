package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise18063 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int total = 0;
        for (int i = 0; i < n; i++) {
            int[] time = Arrays.stream(br.readLine().trim().split(":")).mapToInt(Integer::parseInt).toArray();
            total += time[0]*60 + time[1];
            if (i != 0) {
                total -= c;
            }
        }
        System.out.printf("%02d:%02d:%02d\n", total/3600, (total % 3600)/60, total % 60);
    }
}
