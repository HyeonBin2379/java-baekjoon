package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13672 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input);
            int b = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] r = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken());

                r[c] += v;
                r[d] -= v;
            }

            String answer = "S";
            for (int i = 0; i < b; i++) {
                if (r[i] < 0) {
                    answer = "N";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
