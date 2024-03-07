package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise11531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> checkLog = new TreeMap<>();
        Map<String, Integer> wrongCount = new TreeMap<>();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if (m == -1) {
                break;
            }
            String problem = st.nextToken();
            String result = st.nextToken();
            if (result.equals("wrong")) {
                wrongCount.put(problem, wrongCount.getOrDefault(problem, 0)+1);
            } else {
                if (checkLog.getOrDefault(problem, 0) == 0) {
                    checkLog.put(problem, m);
                }
            }
        }

        int sum = 0;
        for (String problem : checkLog.keySet()) {
            sum += checkLog.getOrDefault(problem, 0) + 20*wrongCount.getOrDefault(problem, 0);
        }
        System.out.print(checkLog.size() + " " + sum);
    }
}
