package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise31908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<String>> nameListByRing = new LinkedHashMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();
            if (ring.equals("-")) {
                continue;
            }
            if (!nameListByRing.containsKey(ring)) {
                nameListByRing.put(ring, new ArrayList<>());
            }
            nameListByRing.get(ring).add(name);
        }

        List<List<String>> answer = nameListByRing.values().stream()
                .filter(nameList -> nameList.size() == 2)
                .toList();
        System.out.println(answer.size());
        answer.stream().map(nameList -> String.join(" ", nameList)).forEach(System.out::println);
    }
}