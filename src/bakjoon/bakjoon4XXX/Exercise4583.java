package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise4583 {

    private static final Map<Character, Character> decalLetter = new TreeMap<>(Map.of(
            'b', 'd','d', 'b', 'p', 'q', 'q', 'p',
            'i','i', 'o','o', 'v', 'v', 'x', 'x',
            'w', 'w'
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char letter = input.charAt(input.length()-1-i);
                if (!decalLetter.containsKey(letter)) {
                    sb.setLength(0);
                    sb.append("INVALID");
                    break;
                }
                sb.append(decalLetter.get(letter));
            }
            System.out.println(sb);
        }
    }
}
