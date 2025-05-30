package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise5614 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> result = new TreeMap<>((o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            return len1 != len2 ? Integer.compare(len1, len2) : o1.compareTo(o2);
        });
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            result.merge(key, value, Integer::sum);
        }
        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
