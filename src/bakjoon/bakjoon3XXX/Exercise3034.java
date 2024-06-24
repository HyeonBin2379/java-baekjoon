package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise3034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(br.readLine());
            if (len*len <= w*w + h*h) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }
        System.out.print(sb);
    }
}
