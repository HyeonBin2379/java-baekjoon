package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise25053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            Map<Integer, Integer> scoreList = new TreeMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                scoreList.put(difficulty, Math.max(score, scoreList.getOrDefault(difficulty, 0)));
            }

            if (scoreList.keySet().size() == 10) {
                sb.append(scoreList.keySet().stream().mapToInt(scoreList::get).sum()).append("\n");
            } else {
                sb.append("MOREPROBLEMS\n");
            }
        }
        System.out.print(sb);
    }
}
