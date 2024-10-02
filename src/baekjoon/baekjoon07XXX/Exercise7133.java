package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise7133 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int dm = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int dh = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int bee = Integer.parseInt(st.nextToken());

            int cowSum = 0;
            for (int j = 0; j < cow; j++) {
                cowSum += Math.max(m-j*dm, 0);
            }

            int beeSum = 0;
            for (int j = 0; j < bee; j++) {
                beeSum += Math.max(h-j*dh, 0);
            }
            total += Math.max(cowSum, beeSum);
        }
        System.out.println(total);
    }
}
