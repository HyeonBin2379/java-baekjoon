package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise18312 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (checkNum(i, j, k, num)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static boolean checkNum(int h, int m, int s, int k) {
        return h / 10 == k || h % 10 == k
                || m / 10 == k || m % 10 == k
                || s / 10 == k || s % 10 == k;
    }
}
