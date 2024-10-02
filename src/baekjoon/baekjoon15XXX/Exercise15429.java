package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15429 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[] gnome = new int[len];
            for (int j = 0; j < len; j++) {
                gnome[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            for (int j = 1; j < len; j++) {
                if (gnome[j]-gnome[j-1] != 1) {
                    answer = j+1;
                    break;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
