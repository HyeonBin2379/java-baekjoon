package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25084 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double total = Math.PI*Math.pow(r, 2);
            while (r > 0) {
                r *= a;
                total += Math.PI*Math.pow(r, 2);
                r /= b;
                total += Math.PI*Math.pow(r, 2);
            }
            sb.append(String.format("Case #%d: %.6f\n", i, total));
        }
        System.out.print(sb);
    }
}
