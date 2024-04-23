package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Exercise2966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] choices = {'A', 'B', 'C'};
        int n = Integer.parseInt(br.readLine());
        char[] answers = br.readLine().toCharArray();

        Map<String, Integer> score = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (answers[i] == choices[i % 3]) {
                score.put("Adrian", score.getOrDefault("Adrian", 0)+1);
            }
            int index = (i % 2 == 0) ? 1 : (i % 4 == 1) ? 0 : 2;
            if (answers[i] == choices[index]) {
                score.put("Bruno", score.getOrDefault("Bruno", 0)+1);
            }
            if (answers[i] == choices[(i/2 + 2) % 3]) {
                score.put("Goran", score.getOrDefault("Goran", 0)+1);
            }
        }

        int max = score.values().stream().max(Comparator.comparingInt(o -> o)).get();
        System.out.println(max);
        score.keySet().stream().filter(s -> score.get(s) == max).forEach(System.out::println);
    }
}
