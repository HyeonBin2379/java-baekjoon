package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Exercise2596 {

    private static final Map<String, String> code = new TreeMap<>(Map.of(
       "000000", "A",
       "001111", "B",
       "010011", "C",
       "011100", "D",
       "100110", "E",
       "101001", "F",
       "110101", "G",
       "111010", "H"
    ));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i += 6) {
            String token = input.substring(i, i+6);
            if (code.containsKey(token)) {
                sb.append(code.get(token));
                continue;
            }

            Map<String, Integer> diffCount = new TreeMap<>();
            for (String key : code.keySet()) {
                int diffCnt = getDiffCnt(key, token);
                diffCount.put(key, diffCnt);
            }

            String similar = diffCount.keySet().stream()
                    .min(Comparator.comparingInt(diffCount::get))
                    .get();
            if (diffCount.get(similar) > 1) {
                System.out.println((i/6)+1);
                return;
            }
            sb.append(code.get(similar));
        }
        System.out.println(sb);
    }

    private static int getDiffCnt(String key, String token) {
        int diffCnt = 0;
        for (int i = 0; i < 6; i++) {
            if (key.charAt(i) != token.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt;
    }
}
