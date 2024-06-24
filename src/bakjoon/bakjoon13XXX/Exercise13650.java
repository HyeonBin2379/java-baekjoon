package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise13650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int testCase = Integer.parseInt(input);
            Map<Integer, List<String>> boots = new TreeMap<>();

            for (int i = 0; i < testCase; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int size = Integer.parseInt(st.nextToken());
                String type = st.nextToken();
                if (!boots.containsKey(size)) {
                    boots.put(size, new ArrayList<>());
                }
                boots.get(size).add(type);
            }

            int answer = 0;
            for (Integer size : boots.keySet()) {
                int left = (int) boots.get(size).stream().filter(s -> s.equals("E")).count();
                int right = boots.get(size).size() - left;
                answer += Math.min(left, right);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
