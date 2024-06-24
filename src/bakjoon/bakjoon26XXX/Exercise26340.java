package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26340 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                if (w > h) {
                    w /= 2;
                } else {
                    h /= 2;
                }
            }
            sb.append(String.format("Data set: %s\n", input));
            sb.append(String.format("%d %d\n\n", Math.max(w, h), Math.min(w, h)));
        }
        br.close();
        System.out.print(sb);
    }
}
