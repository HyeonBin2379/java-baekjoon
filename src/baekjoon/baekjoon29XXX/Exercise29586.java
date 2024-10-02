package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29586 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        char[][][] block = new char[n][h][w];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < h; j++) {
                block[i][j] = br.readLine().toCharArray();
            }
        }

        char[][] image = new char[h][w];
        for (int i = 0; i < h; i++) {
            image[i] = br.readLine().toCharArray();
        }

        int answer = 1;
        int approx = w*h+1;
        for (int i = 0; i < n; i++) {
            int sameCnt = 0;
            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    sameCnt += (image[j][k] == block[i][j][k]) ? 1 : 0;
                }
            }
            int diff = Math.abs(w*h-sameCnt);
            if (approx > diff) {
                approx = diff;
                answer = i+1;
            }
        }
        System.out.println(answer);
    }
}
