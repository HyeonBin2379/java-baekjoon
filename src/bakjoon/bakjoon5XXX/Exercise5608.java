package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise5608 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> wordTable = new HashMap<>();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String before = st.nextToken();
            String after = st.nextToken();
            wordTable.put(before, after);
        }

        StringBuilder answer = new StringBuilder();
        int len = Integer.parseInt(br.readLine());
        for (int i = 0; i < len; i++) {
            String letter = br.readLine();
            answer.append(wordTable.getOrDefault(letter, letter));
        }
        System.out.println(answer);
    }
}
