package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise2954 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> vowel = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        String input = br.readLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));
            if (vowel.contains(input.charAt(i))) {
                i += 2;
            }
        }
        System.out.println(result);
    }
}
