package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int u = 0;
        for (int i = 0; i < n+m; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 1) {
                if (u + 1 > s) {
                    s *= 2;
                }
                u++;
            } else {
                u--;
            }
        }
        System.out.println(s);
    }
}
