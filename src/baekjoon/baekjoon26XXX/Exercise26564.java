package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise26564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> ranks = new LinkedHashMap<>();
            String[] cards = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                char num = cards[j].charAt(0);
                ranks.put(num, ranks.getOrDefault(num, 0)+1);
            }
            System.out.println(ranks.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o))
                    .get());
        }
    }
}
