package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise29723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String lecture = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            result.put(lecture, score);
        }

        Set<String> opened = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            String lecture = br.readLine();
            sum += result.get(lecture);
            opened.add(lecture);
        }

        List<Integer> scores = result.keySet()
                .stream()
                .filter(s -> !opened.contains(s))
                .map(result::get)
                .sorted()
                .toList();
        int min = sum, max = sum;
        for (int i = 0; i < m-k; i++) {
            min += scores.get(i);
            max += scores.get(n-k-1-i);
        }
        System.out.println(min + " " + max);
    }
}
