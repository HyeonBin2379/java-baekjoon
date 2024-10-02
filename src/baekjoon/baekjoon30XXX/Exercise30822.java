package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Exercise30822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> uospc = new HashMap<>(Map.of(
                'u', 0,
                'o', 0,
                's', 0,
                'p', 0,
                'c', 0
        ));
        int len = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (int i = 0; i < len; i++) {
            if (uospc.containsKey(input.charAt(i))) {
                uospc.put(input.charAt(i), uospc.getOrDefault(input.charAt(i), 0)+1);
            }
        }
        System.out.println(uospc.values()
                .stream()
                .min(Integer::compareTo)
                .get());
    }
}
