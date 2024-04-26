package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise20124 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> candidate = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int votes = Integer.parseInt(st.nextToken());
            candidate.put(name, candidate.getOrDefault(name, 0)+votes);
        }
        System.out.println(candidate.keySet().stream()
                .max(Comparator.comparing(candidate::get))
                .get());
    }
}
