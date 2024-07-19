package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise15270 {

    private static int m;
    private static int answer;
    private static boolean[] visited;
    private static int[][] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friend = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            friend[i][0] = Integer.parseInt(st.nextToken());
            friend[i][1] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n +1];
        dfs(0, 0);
        answer *= 2; // 로봇댄스 쌍*2 = 쌍을 이룬 친구의 수
        // 혼자 남은 친구가 있으면 +1, 모두 짝을 이루면 그대로 출력
        System.out.println(answer < n ? answer+1 : answer);
    }

    private static void dfs(int depth, int count) {
        if (depth >= m) {
            answer = Math.max(answer, count);
            return;
        }

        // 둘 중 최소 한 명은 이미 짝이 있는 경우
        if (visited[friend[depth][0]] || visited[friend[depth][1]]) {
            dfs(depth+1, count);
            return;
        }
        visited[friend[depth][0]] = true;
        visited[friend[depth][1]] = true;

        // 짝을 이룬 경우
        dfs(depth + 1, count + 1);

        // 짝을 이루지 않은 경우
        visited[friend[depth][0]] = false;
        visited[friend[depth][1]] = false;

        dfs(depth + 1, count);
    }
}
