package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise3982 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            Map<String, Integer> winCount = new TreeMap<>();
            Map<String, Integer> loseCount = new TreeMap<>();
            for (int j = 0; j < 16; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String home = st.nextToken();
                String away = st.nextToken();
                int homeScore = Integer.parseInt(st.nextToken());
                int awayScore = Integer.parseInt(st.nextToken());
                if (homeScore > awayScore) {
                    winCount.merge(home, 1, Integer::sum);
                    loseCount.merge(away, 1, Integer::sum);
                } else {
                    winCount.merge(away, 1, Integer::sum);
                    loseCount.merge(home, 1, Integer::sum);
                }
            }
            String answer = winCount.keySet().stream()
                    .filter(s -> winCount.get(s) == 4 && loseCount.getOrDefault(s, 0) == 0)
                    .findFirst()
                    .get();
            System.out.println(answer);
        }
    }
}
