package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pros = Integer.parseInt(st.nextToken());
            int cons = Integer.parseInt(st.nextToken());
            double result = dfs(pros, cons, 0, 0);
            sb.append(String.format("Case #%d: %.6f\n", i, result));
        }
        System.out.print(sb);
    }

    private static double dfs(int remPros, int remCons, int currPros, int currCons) {
        if (remPros == 0 || remCons == 0) {
            return 1.0;
        }

        double probPros = (double) remPros / (remPros + remCons);
        double probCons = (double) remCons / (remPros + remCons);

        // A의 유권자가 다음에 투표하는 경우
        double total = probPros * dfs(remPros-1, remCons, currPros+1, currCons);

        // B의 유권자가 다음에 투표하면서 A가 현재의 리드를 유지
        if (currPros > currCons + 1) {
            total += probCons * dfs(remPros, remCons-1, currPros, currCons+1);
        }
        return total;
    }
}
