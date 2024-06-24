package bakjoon.bakjoon28XXX;

import java.io.*;
import java.util.*;

public class Exercise28417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int player = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < player; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] run = new int[2];
            int[] trick = new int[5];
            for (int j = 0; j < 7; j++) {
                if (j < 2) {
                    run[j] = Integer.parseInt(st.nextToken());
                } else {
                    trick[j-2] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.sort(run);
            Arrays.sort(trick);
            int sum = run[1] + (trick[3] + trick[4]);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
