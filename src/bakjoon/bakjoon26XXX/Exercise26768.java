package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise26768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> table = new LinkedHashMap<>(Map.of(
                "a", 4,
                "e", 3,
                "i", 1,
                "o", 0,
                "s", 5
        ));
        String input = br.readLine();
        for (String letter : table.keySet()) {
            input = input.replace(letter, table.get(letter).toString());
        }
        System.out.println(input);
    }
}
