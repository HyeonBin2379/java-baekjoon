package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise11508 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> prices = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            prices.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(prices);

        int total2 = 0;
        int i;
        for (i = prices.size(); i >= 3; i -= 3) {
            int sum = 0;
            List<Integer> subList = prices.subList(Math.max(i-3, 0), i);
            if (subList.size() == 3) {
                sum = subList.stream().reduce(0, Integer::sum) - subList.get(0);
            }
            total2 += sum;
        }
        if (prices.size() % 3 != 0) {
            total2 += prices.subList(0, i).stream().reduce(0, Integer::sum);
        }
        System.out.println(total2);
    }
}
