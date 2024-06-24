package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Exercise25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        Map<String, Integer> students = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            String name = st.nextToken();
            students.put(name, 0);
        }

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                students.put(name, students.get(name)+1);
            }
        }

        List<Entry<String, Integer>> result = new LinkedList<>(students.entrySet());
        result.sort((o1, o2) -> {
            int comparison = (o1.getValue() - o2.getValue()) * (-1);
            return comparison == 0 ? o1.getKey().compareTo(o2.getKey()) : comparison;
        });

        for (Entry<String, Integer> entry : result) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        br.close();
    }
}
