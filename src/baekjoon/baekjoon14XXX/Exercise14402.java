package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise14402 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> log = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            if (status.equals("+")) {
                log.merge(name, 1, Integer::sum);
            } else if (log.getOrDefault(name, 0) == 0) {
                answer++;
            } else {
                log.merge(name, 1, (int1, int2) -> int1-int2);
            }
        }
        System.out.println(log.values().stream().reduce(answer, Integer::sum));
    }
}
