package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise30031 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> money = new LinkedHashMap<>(Map.of(
                136, 1000,
                142, 5000,
                148, 10000,
                154, 50000
        ));

        int testCase = Integer.parseInt(br.readLine());
        int total = 0;
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            total += money.get(w);
        }
        System.out.println(total);
        br.close();
    }
}
