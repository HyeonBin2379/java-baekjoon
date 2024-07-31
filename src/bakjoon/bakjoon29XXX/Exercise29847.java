package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Exercise29847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> letterCount = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            for (char letter : br.readLine().toCharArray()) {
                if (letter != ' ') {
                    letterCount.put(letter, letterCount.getOrDefault(letter, 0)+1);
                }
            }
        }
        letterCount.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
