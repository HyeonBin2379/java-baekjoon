import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11049 {
    private static int[][] size;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        size = new int[testCase+1][2];
        dp = new int[testCase+1][testCase+1];
        for (int i = 1; i < testCase+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size[i][0] = Integer.parseInt(st.nextToken());
            size[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        br.close();
        System.out.println(execute(1, testCase));
    }

    public static int execute(int start, int end) {
        int result = Integer.MAX_VALUE;
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start == end) {
            return 0;
        }
        if (start+1 == end) {
            return size[start][0]* size[end][0]* size[end][1];
        }
        for (int i = start; i < end; i++) {
            result = Math.min(result, size[start][0]*size[i+1][0]*size[end][1] + execute(start, i) + execute(i+1, end));
        }
        return dp[start][end] = result;
    }
}
