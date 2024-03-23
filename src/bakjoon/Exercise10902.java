package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10902 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxS = 0, f = 0;
        int[] time = new int[n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (maxS <= s) {
                f = (maxS == s) ? Math.min(i, f) : i;
                maxS = s;
            }
        }
        System.out.println((maxS == 0) ? 0 : time[f] + (f-1)*20);
    }
}
