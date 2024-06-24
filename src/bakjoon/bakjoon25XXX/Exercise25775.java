package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Exercise25775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());

        char[][] word = new char[count][];
        int maxLen = 0;
        for (int i = 0; i < count; i++) {
            word[i] = br.readLine().toCharArray();
            maxLen = Math.max(word[i].length, maxLen);
        }

        for (int i = 0; i < maxLen; i++) {
            Map<Character, Integer> letter = new TreeMap<>();
            int max = 0;
            for (int j = 0; j < count; j++) {
                if (i >= word[j].length) {
                    continue;
                }
                letter.put(word[j][i], letter.getOrDefault(word[j][i], 0)+1);
                max = Math.max(letter.get(word[j][i]), max);
            }

            List<Character> result = new ArrayList<>(letter.keySet());
            result.sort((o1, o2) -> {
                if (!Objects.equals(letter.get(o1), letter.get(o2))) {
                    return letter.get(o2) - letter.get(o1);
                } else {
                    return o1.compareTo(o2);
                }
            });
            int finalMax = max;
            sb.append(String.format("%d:", i+1));
            result.stream().filter(ch -> letter.get(ch) == finalMax).forEach(ch -> sb.append(" ").append(ch));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
