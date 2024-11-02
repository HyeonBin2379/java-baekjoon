package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise27445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int min1 = Integer.MAX_VALUE;
        for (int i = 1; i < row; i++) {
            int dist = Integer.parseInt(br.readLine());
            if (min1 > dist) {
                min1 = dist;
            }
        }
        int min2 = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= col; i++) {
            int dist = Integer.parseInt(st.nextToken());
            if (i == 1) {
                if (min1 > dist) {
                    min1 = dist;
                }
            }
            if (min2 > dist) {
                min2 = dist;
            }
        }
        System.out.println((row-min2) + " " + (1+min1));
    }
}
