package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Exercise25329 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> totalTime = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = calculateTime(st.nextToken());
            String user = st.nextToken();
            totalTime.put(user, totalTime.getOrDefault(user, 0)+time);
        }
        Map<String, Integer> totalCost = new HashMap<>();
        for (Entry<String, Integer> user : totalTime.entrySet()) {
            int unit = (int) Math.ceil((double)Math.max(user.getValue()-100, 0)/50);
            int cost = 10 + 3*unit;
            totalCost.put(user.getKey(), cost);
        }
        totalCost.entrySet().stream()
                .sorted((o1, o2) -> !o1.getValue().equals(o2.getValue())
                        ? Integer.compare(o2.getValue(), o1.getValue())
                        : o1.getKey().compareTo(o2.getKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    private static int calculateTime(String input) {
        int[] time = Arrays.stream(input.split(":")).mapToInt(Integer::parseInt).toArray();
        return time[0]*60 + time[1];
    }
}
