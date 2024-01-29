package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


class VowelDictionarySolution {
    private final Set<String> dictionary = new LinkedHashSet<>();
    private final String[] vowel = {"", "A", "E", "I", "O", "U"};

    public int solution(String word) {
        backtracking(5, "");
        List<String> result = new ArrayList<>(dictionary);
        Collections.sort(result);
        return result.indexOf(word);
    }

    public void backtracking(int step, String word) {
        if (step == 0) {
            dictionary.add(word);
            return;
        }

        for (String s : vowel) {
            backtracking(step - 1, word + s);
        }
    }
}
public class VowelDictionary {
    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(new VowelDictionarySolution().solution(word));
    }
}
