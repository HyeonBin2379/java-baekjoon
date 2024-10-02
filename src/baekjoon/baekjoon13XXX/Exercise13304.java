package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise13304 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] room = new int[2][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken())-1;
            room[gender][grade/2]++;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                count += (int) Math.ceil((double)(room[0][i] + room[1][i])/k);
                continue;
            }
            for (int j = 0; j < 2; j++) {
                count += (int) Math.ceil((double)room[j][i]/k);
            }
        }
        System.out.println(count);
    }
}
