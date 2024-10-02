package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Exercise11652 {
    private static final Map<Long, Integer> cardCount = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            Long cardNum = Long.parseLong(br.readLine());
            cardCount.put(cardNum, cardCount.getOrDefault(cardNum, 0)+1);
        }
        br.close();

        List<Long> keySet = new ArrayList<>(cardCount.keySet());
        keySet.sort((o1, o2) -> {
            if (!Objects.equals(cardCount.get(o1), cardCount.get(o2))) {
                return cardCount.get(o2) - cardCount.get(o1);
            } else {
                return Long.compare(o1, o2);
            }
        });
        System.out.println(keySet.get(0));
    }
}
