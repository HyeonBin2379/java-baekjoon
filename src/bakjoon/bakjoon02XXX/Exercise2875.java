package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 0; i <= k; i++) {
            int female = n-i;
            int male = m-k+i;
            if (female >= 2 || male >= 1) {
                max = Math.max(max, Math.min(female/2, male));
            }
        }
        System.out.println(max);
    }
}
