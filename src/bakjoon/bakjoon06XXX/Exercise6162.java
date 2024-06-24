package bakjoon.bakjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise6162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            sb.append(String.format("Data Set %d:\n", i));
            if (e <= a) {
                sb.append("no drought\n\n");
                continue;
            }

            for (int j = 1; (int) Math.pow(5, j)*a < e; j++) {
                sb.append("mega ");
            }
            sb.append("drought\n\n");
        }
        System.out.print(sb);
    }
}
