package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise11507 {

    private static final Map<String, Integer> cardSet = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] cards = new String[input.length()/3];
        for (int i = 0; i < input.length(); i += 3) {
            cards[i/3] = input.substring(i, i+3);
        }

        int count = Arrays.stream(cards).collect(Collectors.toSet()).size();
        if (count != cards.length) {
            System.out.println("GRESKA");
            return;
        }

        setCards();
        for (String card : cards) {
            cardSet.put(card.substring(0, 1), cardSet.get(card.substring(0, 1)) - 1);
        }
        cardSet.values().forEach(integer -> System.out.print(integer + " "));
    }

    private static void setCards() {
        cardSet.put("P", 13);
        cardSet.put("K", 13);
        cardSet.put("H", 13);
        cardSet.put("T", 13);
    }
}
