package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercise1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> firstLetter = new TreeMap<>();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String firstName = br.readLine();
            String letter = String.valueOf(firstName.charAt(0));
            firstLetter.put(letter, firstLetter.getOrDefault(letter, 0) + 1);
        }
        String result = firstLetter.keySet().stream()
                .filter(s -> firstLetter.get(s) >= 5)
                .collect(Collectors.joining());
        System.out.println(result.isEmpty() ? "PREDAJA" : result);
    }
}
