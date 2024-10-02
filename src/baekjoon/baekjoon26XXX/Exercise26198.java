package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise26198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> value = new LinkedHashMap<>(Map.of(
           'I', 1, 'V', 5, 'X', 10, 'L', 50,
           'C', 100, 'D', 500, 'M', 1000
        ));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            char[] input = br.readLine().toCharArray();
            int total = 0;
            for (char c : input) {
                if (value.containsKey(c)) {
                    total += value.get(c);
                }
            }
            System.out.println(total);
        }
    }
}
