import java.io.*;
import java.util.*;

public class Exercise20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int minLimit = Integer.parseInt(st.nextToken());

        Map<String, Integer> vocabulary = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String word = br.readLine();
            if (word.length() >= minLimit) {
                vocabulary.put(word, vocabulary.getOrDefault(word, 0)+1);
            }
        }
        br.close();
        List<String> words = new ArrayList<>(vocabulary.keySet());
        words.sort((o1, o2) -> {
            if (!Objects.equals(vocabulary.get(o1), vocabulary.get(o2))) {
                return Integer.compare(vocabulary.get(o2), vocabulary.get(o1));
            }
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }
}
