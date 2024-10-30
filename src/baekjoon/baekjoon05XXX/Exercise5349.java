package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Exercise5349 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> count = new HashMap<>();
        while (true) {
            String ssn = br.readLine();
            if (ssn.equals("000-00-0000")) {
                break;
            }
            count.merge(ssn, 1, Integer::sum);
        }
        count.keySet().stream().filter(s -> count.get(s) > 1).sorted().forEach(System.out::println);
    }
}
