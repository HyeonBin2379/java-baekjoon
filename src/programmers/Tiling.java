package programmers;

class TilingSolution {
    private static final int MOD = 1000000007;

    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
            for (int i = 3; i < n+1; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % MOD;
            }
        }
        return dp[n];
    }
}
public class Tiling {
    public static void main(String[] args) {
        System.out.println(new TilingSolution().solution(4));
    }
}
