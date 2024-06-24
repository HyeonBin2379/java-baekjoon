package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise30063 {
    private static final Map<Character, Integer> answer = new TreeMap<>(Map.of(
            'A', 2,
            'K', 1,
            'R', 1,
            'S', 1,
            'T', 1
    ));
    private static final Map<Character, Integer> count = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (answer.containsKey(str[i])) {
                count.put(str[i], count.getOrDefault(str[i], 0)+1);
                if (isMatched()) {
                    result = i+1;
                    break;
                }
            }
        }
        System.out.println(Math.min(result, len));
    }

    public static boolean isMatched() {
        for (char letter : answer.keySet()) {
            if (!count.containsKey(letter) || count.get(letter) < answer.get(letter)) {
                return false;
            }
        }
        return true;
    }
}
