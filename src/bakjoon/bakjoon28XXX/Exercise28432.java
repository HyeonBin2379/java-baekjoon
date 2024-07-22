package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise28432 {

    private static final List<String> wordList = new ArrayList<>();
    private static char prevSuffix, nextPrefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int blanked = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("?")) {
                blanked = i;
            }
            wordList.add(input);
        }

        int m = Integer.parseInt(br.readLine());
        if (blanked > 0) {
            prevSuffix = wordList.get(blanked-1).charAt(wordList.get(blanked-1).length() - 1);
        }
        if (blanked < wordList.size()-1) {
            nextPrefix = wordList.get(blanked+1).charAt(0);
        }
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            if (n == 1 || (!wordList.contains(word) && isMatched(blanked, word))) {
                System.out.println(word);
                break;
            }
        }
    }

    private static boolean isMatched(int blanked, String word) {
        String prefix = String.valueOf(prevSuffix);
        String suffix = String.valueOf(nextPrefix);
        return (blanked == 0 && word.endsWith(suffix))
                || (blanked == wordList.size() - 1 && word.startsWith(prefix))
                || (blanked > 0 && blanked < wordList.size() - 1 && word.startsWith(prefix) && word.endsWith(suffix));
    }
}
