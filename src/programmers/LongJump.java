package programmers;

class LongJumpSolution {
    private static final int MOD = 1234567;

    public long solution(int n) {
        long[] casesByDistance = new long[n+1];
        casesByDistance[0] = 1 % MOD;
        casesByDistance[1] = 1 % MOD;
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                casesByDistance[i] = casesByDistance[i-1] + casesByDistance[i-2];
                casesByDistance[i] %= MOD;
            }
        }
        return casesByDistance[n];
    }
}
public class LongJump {
    public static void main(String[] args) {
        System.out.println(new LongJumpSolution().solution(4));
    }
}
