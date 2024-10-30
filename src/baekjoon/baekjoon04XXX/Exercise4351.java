package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise4351 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Long> valueByWord = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            long value = Long.parseLong(st.nextToken());
            valueByWord.put(word, value);
        }

        while (m-- > 0) {
            long total = 0L;
            while (true) {
                String input = br.readLine();
                if (input.equals(".")) {
                    System.out.println(total);
                    break;
                }
                total += Arrays.stream(input.split(" "))
                        .filter(valueByWord::containsKey)
                        .map(valueByWord::get)
                        .reduce(0L, Long::sum);
            }
        }
    }
}
