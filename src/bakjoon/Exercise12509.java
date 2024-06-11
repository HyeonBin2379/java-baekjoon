package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise12509 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Map<String, Integer> moves = new HashMap<>(Map.of("B", 1, "O", 1));
            int bTime = 0, oTime = 0;

            for (int j = 0; j < n; j++) {
                String robot = st.nextToken();
                int next = Integer.parseInt(st.nextToken());
                int diff = Math.abs(next-moves.get(robot));
                if (robot.equals("B")) {
                    bTime = Math.max(bTime + diff, oTime) + 1;
                } else {
                    oTime = Math.max(oTime + diff, bTime) + 1;
                }
                moves.put(robot, next);
            }
            sb.append(String.format("Case #%d: %d\n", i, Math.max(bTime, oTime)));
        }
        System.out.print(sb);
    }
}
