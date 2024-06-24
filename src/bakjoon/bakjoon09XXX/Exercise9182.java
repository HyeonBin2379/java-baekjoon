package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9182 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (true) {
            String input = br.readLine();
            if (input.equals("-1 -1 -1 -1")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int p = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            for (int j = day+1; j <= 21252; j++) {
                if (j % 23 == p % 23
                        && j % 28 == e % 28
                        && j % 33 == i % 33) {
                    sb.append(String.format("Case %d: the next triple peak occurs in %d days.\n", ++count, j-day));
                }
            }
        }
        System.out.print(sb);
    }
}
