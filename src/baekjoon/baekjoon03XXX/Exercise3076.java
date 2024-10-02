package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3076 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < a; j++) {
                for (int k = 0; k < c; k++) {
                    if (k % 2 == i % 2) {
                        sb.append("X".repeat(b));
                    } else {
                        sb.append(".".repeat(b));
                    }
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
