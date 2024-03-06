package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise12250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int m = 0; m < a; m++) {
                for (int n = 0; n < b; n++) {
                    if ((m & n) < k) {
                        count++;
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, count));
        }
        System.out.print(sb);
    }
}
