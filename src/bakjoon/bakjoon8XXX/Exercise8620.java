package bakjoon.bakjoon8XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise8620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> result = new TreeMap<>();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String item = st.nextToken();
            int quantity = Integer.parseInt(st.nextToken());
            result.put(item, result.getOrDefault(item, 0) + quantity);
        }
        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
