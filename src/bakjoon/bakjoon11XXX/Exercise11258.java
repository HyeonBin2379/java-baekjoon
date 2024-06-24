package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise11258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> winning = new LinkedHashMap<>();
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String lottoNum = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            winning.put(lottoNum, price);
        }

        List<Map.Entry<String, Integer>> entrySet = new ArrayList<>(winning.entrySet());
        while (true) {
            String lottoNum = br.readLine();
            if (lottoNum.equals("-1")) {
                break;
            }
            int total = 0;
            for (int i = 0; i < 6; i++) {
                Map.Entry<String, Integer> entry = entrySet.get(i);
                if (i == 0) {
                    total += lottoNum.equals(entry.getKey()) ? entry.getValue() : 0;
                } else if (i < 3) {
                    total += lottoNum.startsWith(entry.getKey()) ? entry.getValue() : 0;
                } else {
                    total += lottoNum.endsWith(entry.getKey()) ? entry.getValue() : 0;
                }
            }
            System.out.println(total);
        }
    }
}
