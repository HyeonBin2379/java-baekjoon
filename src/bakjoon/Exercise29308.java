package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise29308 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> russian = new LinkedHashMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int salary = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            String nationality = st.nextToken();
            if (nationality.equals("Russia")) {
                russian.put(name, salary);
            }
        }
        System.out.println(russian.keySet().stream().max(Comparator.comparingInt(russian::get)).get());
    }
}
