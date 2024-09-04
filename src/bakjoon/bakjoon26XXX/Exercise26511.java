package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Exercise26511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            String input = br.readLine();
            Map<String, Long> letterCnt = Arrays.stream(input.split(""))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
            List<String> letterSet = letterCnt.entrySet().stream()
                    .sorted(Comparator.comparingLong(Entry::getValue))
                    .map(Entry::getKey)
                    .toList();

            int count = 0;
            for (String letter : letterSet) {
                if (letterCnt.values().stream().filter(cnt -> cnt > 0).count() <= 2) {
                    break;
                }
                count += letterCnt.get(letter);
                letterCnt.put(letter, 0L);
            }
            System.out.println(count);
        }
    }
}
