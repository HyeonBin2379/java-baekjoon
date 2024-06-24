package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise1544 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String>[] arr = new ArrayList[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            arr[i] = getWordSet(word);

            boolean isNewWord = true;
            for (int j = 0; j <= i-1; j++) {
                if (arr[j].contains(word)) {
                    isNewWord = false;
                    break;
                }
            }
            if (isNewWord) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static List<String> getWordSet(String word) {
        List<String> result = new ArrayList<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            result.add(word.substring(i, len) + word.substring(0, i));
        }
        return result;
    }
}
