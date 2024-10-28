package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise5637 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> total = new ArrayList<>();
        String input;
        while ((input = br.readLine()) != null) {
            String[] words = input.trim().split("[^a-zA-Z-]");
            List<String> result = Arrays.stream(words)
                    .filter(s -> !s.equals("E-N-D") && !s.isEmpty())
                    .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
                    .map(String::trim)
                    .toList();
            total.addAll(result);
        }
        total.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
        System.out.println(total.get(0).toLowerCase());
    }
}
