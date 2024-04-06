package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Exercise26676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> count = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String work = st.nextToken();
            count.put(work, count.getOrDefault(work, 0)+1);
        }

        if (n < 18 || count.keySet().size() != 15) {
            System.out.println("NIE");
            return;
        }

        Set<String> temp = count.keySet().stream().filter(s -> s.startsWith("5")).collect(Collectors.toSet());
        for (String work : temp) {
            if (count.get(work) < 2) {
                System.out.println("NIE");
                return;
            }
        }
        System.out.println("TAK");
    }
}
