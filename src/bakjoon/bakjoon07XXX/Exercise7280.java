package bakjoon.bakjoon07XXX;

import java.io.*;
import java.util.*;

public class Exercise7280 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> card = new LinkedHashMap<>();
        for (int i = 0; i < 51; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            card.put(type, card.getOrDefault(type, 0)+num);
        }
        for (String type : card.keySet()) {
            if (card.get(type) != 91) {
                System.out.println(type + " " + (91-card.get(type)));
                break;
            }
        }
    }
}
