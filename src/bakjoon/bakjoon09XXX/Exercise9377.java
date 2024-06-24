package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise9377 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            String[] words = new String[n];
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
                minLen = Math.min(words[i].length(), minLen);
            }

            List<String> newWords = new ArrayList<>();
            int count = 0;
            for (int i = 1; i < minLen; i++) {
                boolean duplicated = false;
                for (int j = 0; j < n; j++) {
                    if (newWords.contains(words[j].substring(i))) {
                        duplicated = true;
                        break;
                    }
                    newWords.add(words[j].substring(i));
                }
                if (duplicated) {
                    break;
                }
                count++;
            }

            System.out.println(count);
        }
    }
}
