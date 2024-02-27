package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise5753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (n == 0 && d == 0) {
                break;
            }

            Boolean[][] dinner = new Boolean[d][n];
            for (int j = 0; j < d; j++) {
                dinner[j] = Arrays.stream(br.readLine().split(" "))
                        .map(s -> s.equals("1"))
                        .toArray(Boolean[]::new);
            }
            sb.append(hasAnyAttended(dinner, n, d) ? "yes\n" : "no\n");
        }
        System.out.print(sb);
    }

    public static boolean hasAnyAttended(Boolean[][] dinner, int n, int d) {
        for (int i = 0; i < n; i++) {
            boolean attended = true;
            for (int j = 0; j < d; j++) {
                attended &= dinner[j][i];
            }
            if (attended) {
                return true;
            }
        }
        return false;
    }
}
