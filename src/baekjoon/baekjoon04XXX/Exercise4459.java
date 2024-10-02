package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise4459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> rule = new LinkedHashMap<>();
        int q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= q; i++) {
            String input = br.readLine();
            rule.put(i, input);
        }

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(String.format("Rule %d: %s\n", num, rule.getOrDefault(num, "No such rule")));
        }
        System.out.print(sb);
    }
}
