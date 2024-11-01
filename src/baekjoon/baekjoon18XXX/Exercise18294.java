package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise18294 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> wordCount = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            wordCount.merge(word, 1, Integer::sum);
        }
        System.out.println(wordCount.keySet().stream()
                .filter(s -> wordCount.get(s) > n-wordCount.get(s))
                .findAny()
                .orElse("NONE"));
    }
}
