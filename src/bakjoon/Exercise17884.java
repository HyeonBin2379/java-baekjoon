package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise17884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> order = new TreeMap<>();
        for (int i = 2; i <= count; i++) {
            order.put(Integer.parseInt(st.nextToken()), i);
        }

        System.out.print(1);
        for (Integer num : order.values()) {
            System.out.print(" " + num);
        }
    }
}
