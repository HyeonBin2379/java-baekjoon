package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise14889 {

    private static int n, answer;
    private static int[][] stat;
    private static boolean[] isStart;   // 스타트 팀에 속한 사람을 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stat = new int[n][n];
        for (int i = 0; i < n; i++) {
            stat[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 스타트 팀과 링크 팀 나누기 - 백트래킹
        isStart = new boolean[n];
        answer = Integer.MAX_VALUE;
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int count, int start) {
        if (count == n/2) {
            // 스타트 팀과 링크 팀을 구분한다.
            int[] startTeam = IntStream.range(0, n).filter(idx -> isStart[idx]).toArray();
            int[] linkTeam = IntStream.range(0, n).filter(idx -> !isStart[idx]).toArray();

            // 각 팀별 능력치 총합을 계산한다.
            int startStat = getStat(startTeam);
            int linkStat = getStat(linkTeam);

            // 절댓값의 최솟값은 0이므로, 능력치의 차가 0이 나오는 즉시 종료한다.
            if (startStat == linkStat) {
                System.out.println(0);
                System.exit(0);
            }
            // 능력치의 차가 0이 아니면 기존 값과 비교하고 최솟값을 구한다.
            answer = Math.min(Math.abs(startStat-linkStat), answer);
            return;
        }
        for (int i = start; i < n; i++) {
            if (!isStart[i]) {
                isStart[i] = true;
                backtracking(count+1, i);
                isStart[i] = false;
            }
        }
    }

    private static int getStat(int[] team) {
        int total = 0;

        for (int i = 0; i < team.length-1; i++) {
            for (int j = i+1; j < team.length; j++) {
                // 팀의 i번째 사람과 j번째 사람의 등번호 쌍을 구한 다음, 팀에 더해지는 능력치를 구한다.
                total += (stat[team[i]][team[j]]+stat[team[j]][team[i]]);
            }
        }
        return total;
    }
}
