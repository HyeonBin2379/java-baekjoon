package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise4446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> vowel = new ArrayList<>(List.of('a', 'i', 'y', 'e', 'o', 'u'));
        List<Character> consonant = new ArrayList<>(List.of('b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'));

        String input;
        while ((input = br.readLine()) != null) {
            char[] str = input.toCharArray();
            for (int i = 0; i < str.length; i++) {
                char letter = Character.toLowerCase(str[i]);
                boolean isUpperCase = Character.toUpperCase(str[i]) == str[i];

                if (vowel.contains(letter)) {
                    int index = vowel.indexOf(letter) + 3;
                    letter = vowel.get(index % 6);
                    str[i] = isUpperCase ? Character.toUpperCase(letter) : letter;
                } else if (consonant.contains(letter)) {
                    int index = consonant.indexOf(letter) + 10;
                    letter = consonant.get(index % 20);
                    str[i] = isUpperCase ? Character.toUpperCase(letter) : letter;
                }
            }
            System.out.println(new String(str));
        }
        br.close();
    }
}
