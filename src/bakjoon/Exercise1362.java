package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1362 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (o == 0 && w == 0) {
                break;
            }

            sb.append(++testCase);
            while (true) {
                String input = br.readLine();
                if (input.equals("# 0")) {
                    break;
                }

                st = new StringTokenizer(input);
                String cond = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (w <= 0) {
                    continue;
                }

                switch (cond) {
                    case "E" -> w -= n;
                    case "F" -> w += n;
                }
            }

            if (w <= 0) {
                sb.append(" RIP\n");
            } else if (o/2 < w && w < o*2) {
                sb.append(" :-)\n");
            } else {
                sb.append(" :-(\n");
            }
        }
        System.out.print(sb);
    }
}
