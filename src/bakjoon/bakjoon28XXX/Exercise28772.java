package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise28772 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> result = new TreeMap<>();
        String[] word = br.readLine().split(" ");
        for (String s : word) {
            if (s.startsWith("#")) {
                if (s.length() >= 2 && !s.substring(1).contains("#")) {
                    result.put(s, result.getOrDefault(s, 0) + 1);
                }
            }
        }
        System.out.println(result.size());
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
