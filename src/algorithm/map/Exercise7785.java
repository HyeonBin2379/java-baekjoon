package algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Boolean> attended = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean status = st.nextToken().equals("enter");

            if (attended.containsKey(name)) {
                attended.put(name, !attended.get(name));
            } else {
                attended.put(name, status);
            }
        }
        attended.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .filter(attended::get)
                .forEach(System.out::println);
    }
}
