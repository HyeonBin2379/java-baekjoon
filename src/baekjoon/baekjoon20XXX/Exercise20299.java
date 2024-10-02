package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise20299 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] team = new int[n][3];
        for (int i = 0; i < n; i++) {
            boolean isAnswer = true;
            int total = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                team[i][j] = Integer.parseInt(st.nextToken());
                if (team[i][j] < l) {
                    isAnswer = false;
                }
                total += team[i][j];
            }
            if (isAnswer && total >= k) {
                answer.add(i);
            }
        }
        sb.append(answer.size()).append("\n");
        for (Integer index : answer) {
            Arrays.stream(team[index]).forEach(value -> sb.append(value).append(" "));
        }
        System.out.println(sb);
    }
}
