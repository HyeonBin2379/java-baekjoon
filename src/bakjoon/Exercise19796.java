package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise19796 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] fence = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            for (int j = l; j <= r; j++) {
                if (!fence[j]) {
                    fence[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (!fence[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
