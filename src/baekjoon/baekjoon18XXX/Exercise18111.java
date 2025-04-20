package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] land = new int[n][m];
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(land[i][j], maxHeight);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;
        for (int k = 0; k <= maxHeight; k++) {
            int usedBlock = 0;
            int takenBlock = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (land[i][j] > k) {
                        takenBlock += (land[i][j] - k);
                    } else {
                        usedBlock += (k - land[i][j]);
                    }
                }
            }

            if (usedBlock > takenBlock+b) {
                continue;
            }

            int count = takenBlock*2 + usedBlock;
            if (count <= time) {
                time = count;
                height = k;
            }
        }
        System.out.println(time + " " + height);
    }
}
