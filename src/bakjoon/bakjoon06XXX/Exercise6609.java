package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise6609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                int newCnt = m;
                m = p / s;
                p = l / r;
                l = newCnt * e;
            }
            sb.append(m).append("\n");
        }
        System.out.print(sb);
    }
}
