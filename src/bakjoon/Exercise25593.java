package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise25593 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> workLog = new LinkedHashMap<>();
        int[] workTime = {4, 6, 4, 10};
        int week = Integer.parseInt(br.readLine());
        for (int i = 0; i < week; i++) {
            for (int j = 0; j < 4; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 7; k++) {
                    String name = st.nextToken();
                    if (name.equals("-")) {
                        continue;
                    }

                    if (!workLog.containsKey(name)) {
                        workLog.put(name, workTime[j]);
                    } else {
                        workLog.put(name, workLog.get(name)+workTime[j]);
                    }
                }
            }
        }

        int max = 0, min = Integer.MAX_VALUE;
        for (Integer time : workLog.values()) {
            max = Math.max(time, max);
            min = Math.min(time, min);
        }
        System.out.println((max-min > 12) ? "No" : "Yes");
    }
}
