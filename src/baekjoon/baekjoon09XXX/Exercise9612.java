package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Exercise9612 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> dictionary = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            dictionary.merge(word, 1, Integer::sum);
        }
        int max = dictionary.values().stream().reduce(0, Integer::max);
        dictionary.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .findFirst()
                .ifPresent(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
