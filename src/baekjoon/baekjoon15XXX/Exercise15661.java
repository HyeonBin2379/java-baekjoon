package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15661 {

    private static int n;
    private static int minDiff = Integer.MAX_VALUE;
    private static int[][] status;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        status = new int[n][n];
        for (int i = 0; i < n; i++) {
            status[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        selected = new boolean[n];
        selectTeam(0);
        System.out.println(minDiff);
    }

    private static void selectTeam(int count) {
        // 모든 직원의 팀 배정이 완료된 경우
        if (count == n) {
            getStatDiff();
            return;
        }

        // 현재 직원이 스타트 팀에 속한 경우
        selected[count] = true;
        selectTeam(count+1);

        // 현재 직원이 링크 팀에 속한 경우
        selected[count] = false;
        selectTeam(count+1);
    }

    private static void getStatDiff() {
        int start = 0, link = 0;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (selected[i] != selected[j]) {
                    continue;
                }
                // 소속된 팀이 서로 같은 경우 능력치 합산
                if (selected[i]) {
                    start += (status[i][j] + status[j][i]);
                } else {
                    link += (status[i][j] + status[j][i]);
                }
            }
        }
        // 능력치 차가 0이 된 경우 이보다 차가 더 작을 수 없으므로 그대로 종료
        int diff = Math.abs(start-link);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }
        // 두 팀의 능력치 차의 최소값 갱신
        minDiff = Math.min(diff, minDiff);
    }
}
