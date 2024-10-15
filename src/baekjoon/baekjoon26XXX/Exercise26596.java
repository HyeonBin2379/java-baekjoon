package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise26596 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> beverage = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            beverage.merge(name, amount, Integer::sum);
        }
        for (String name1 : beverage.keySet()) {
            for (String name2 : beverage.keySet()) {
                if (name1.equals(name2)) {
                    continue;
                }
                int golden = (int) (beverage.get(name1)*1.618);
                if (beverage.get(name2).equals(golden)) {
                    System.out.println("Delicious!");
                    return;
                }
            }
        }
        System.out.println("Not Delicious...");
    }
}
