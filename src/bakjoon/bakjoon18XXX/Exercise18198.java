package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Exercise18198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> score = new HashMap<>(Map.of('A', 0, 'B', 0));
        String gameLog = br.readLine();
        for (int i = 1; i < gameLog.length(); i += 2) {
            score.put(gameLog.charAt(i-1),
                    score.get(gameLog.charAt(i-1)) + Integer.parseInt(String.valueOf(gameLog.charAt(i))));
        }
        br.close();
        System.out.println((score.get('A') > score.get('B')) ? "A" : "B");
    }
}
