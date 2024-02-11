package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise4659 {
    private static final Set<Character> vowel = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    private static final Set<Character> consonant = new HashSet<>(
            List.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z')
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            if (!hasVowel(input) || isTripleSame(input)) {
                System.out.printf("<%s> is not acceptable.\n", input);
                continue;
            }

            if (hasValidContinuousLetter(input)) {
                System.out.printf("<%s> is acceptable.\n", input);
            } else {
                System.out.printf("<%s> is not acceptable.\n", input);
            }
        }
        br.close();
    }

    public static boolean hasVowel(String input) {
        return vowel.stream().anyMatch(character -> input.contains(String.valueOf(character)));
    }

    public static boolean isTripleSame(String input) {
        for (int i = 0; i < input.length()-2; i++) {
            Set<Character> temp = new HashSet<>(List.of(input.charAt(i), input.charAt(i+1), input.charAt(i+2)));
            if (vowel.containsAll(temp) || consonant.containsAll(temp)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasValidContinuousLetter(String input) {
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) == input.charAt(i+1)) {
                return (input.contains("ee") || input.contains("oo"));
            }
        }
        return true;
    }
}
