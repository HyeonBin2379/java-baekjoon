package codekata.programmers;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

    private final String[] vowels = {"", "A", "E", "I", "O", "U"};
    private final List<String> dictionaries = new ArrayList<>();

    private String[] selected;

    public int solution(String word) {
        selected = new String[5];

        backtracking(0, "");
        dictionaries.sort(String::compareTo);
        return dictionaries.indexOf(word);
    }

    private void backtracking(int step, String word) {
        if (step == 5) {
            if (!dictionaries.contains(word)) {
                dictionaries.add(word);
            }
            return;
        }
        for (String vowel : vowels) {
            selected[step] = vowel;
            backtracking(step + 1, word + selected[step]);
            selected[step] = "";
        }
    }

    public static void main(String[] args) {
        String word = "AAAAE";
        int result = new VowelDictionary().solution(word);
        System.out.println(result);
    }
}
