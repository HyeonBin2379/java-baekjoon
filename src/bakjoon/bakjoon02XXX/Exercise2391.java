package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise2391 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String sascha = br.readLine();
            int w = Integer.parseInt(br.readLine());

            Map<String, Integer> words = new LinkedHashMap<>();
            for (int j = 0; j < w; j++) {
                String word = br.readLine();
                int count = 0;
                for (int k = 0; k < sascha.length(); k++) {
                    if (word.charAt(k) == sascha.charAt(k)) {
                        count++;
                    }
                }
                words.put(word, count);
            }
            System.out.println(words.keySet().stream().max(Comparator.comparingInt(words::get)).get());
        }
    }
}
