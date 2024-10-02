package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise14641 {

    private static final boolean[][] graph = new boolean[26][26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        IntStream.rangeClosed(0, 25).forEach(i -> graph[i][i] = true);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0)-'a';
            int b = st.nextToken().charAt(0)-'a';
            graph[a][b] = true;
        }

        floyd();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            String word1 = st.nextToken();
            String word2 = st.nextToken();

            if (word1.length() != word2.length()) {
                System.out.println("no");
                continue;
            }
            System.out.println(canTranslate(word1, word2) ? "yes" : "no");
        }
    }

    private static void floyd() {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
    }

    private static boolean canTranslate(String word1, String word2) {
        return IntStream.rangeClosed(0, word1.length()-1)
                .allMatch(i -> graph[word1.charAt(i)-'a'][word2.charAt(i)-'a']);
    }
}
