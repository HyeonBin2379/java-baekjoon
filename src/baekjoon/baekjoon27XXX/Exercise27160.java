package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise27160 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> card = new LinkedHashMap<>();
        int round = Integer.parseInt(br.readLine());

        for (int i = 0; i < round; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            card.put(fruit, card.getOrDefault(fruit, 0)+count);
        }
        if (card.values().stream().anyMatch(integer -> integer == 5)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
