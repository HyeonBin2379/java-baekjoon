package programmers;

class Tiling2Solution {
    private static final int MOD = 1000000007;

    public int solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }

        long sum = 0;
        long[] dp = new long[n+1];
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = (3*dp[i-2] + (sum*2 + 2)) % MOD;
            sum += dp[i-2] % MOD;
        }
        return (int) dp[n];
    }
}
public class Tiling2 {
    public static void main(String[] args) {
        System.out.println(new Tiling2Solution().solution(4));
    }
}
