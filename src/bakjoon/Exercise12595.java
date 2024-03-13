package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise12595 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int len = Integer.parseInt(br.readLine());
            Map<Integer, Integer> count = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < len; j++) {
                int num = Integer.parseInt(st.nextToken());
                count.put(num, count.getOrDefault(num, 0)+1);
            }
            for (Integer num : count.keySet()) {
                if (count.get(num) % 2 == 1) {
                    sb.append(String.format("Case #%d: %d\n", i, num));
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
