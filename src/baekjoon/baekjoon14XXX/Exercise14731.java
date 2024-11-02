package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14731 {

    private static final int MOD = (int)1e9+7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long c = Long.parseLong(st.nextToken());
            long exp = Long.parseLong(st.nextToken());
            answer = (answer + ((c*exp) % MOD) * powerTwo(exp-1)) % MOD;
        }
        System.out.println(answer);
    }

    private static long powerTwo(long exp) {
        if (exp == 0) {
            return 1L;
        }
        if (exp % 2 == 1) {
            return (powerTwo(exp-1)*2) % MOD;
        }
        long half = powerTwo(exp/2);
        return (half * half) % MOD;
    }
}
