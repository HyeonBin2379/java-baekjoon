package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise14544 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Map<String, Integer> candidate = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                String name = br.readLine();
                candidate.put(name, 0);
            }
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                String candid = st.nextToken();
                int count = Integer.parseInt(st.nextToken());
                String voter = st.nextToken();
                candidate.put(candid, candidate.get(candid)+count);
            }

            List<String> result = new ArrayList<>(candidate.keySet());
            result.sort((o1, o2) -> candidate.get(o2) - candidate.get(o1));
            int max = candidate.get(result.get(0));
            if (result.stream().filter(s -> candidate.get(s) == max).count() > 1) {
                sb.append(String.format("VOTE %d: THERE IS A DILEMMA\n", i));
            } else {
                sb.append(String.format("VOTE %d: THE WINNER IS %s %d\n", i, result.get(0), max));
            }
        }
        System.out.print(sb);
    }
}
