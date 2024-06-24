package bakjoon.bakjoon7XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        Map<String, String> record = new LinkedHashMap<>();

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (record.containsKey(name)) {
                record.remove(name);
            }
            else {
                record.put(name, state);
            }
        }

        List<String> result = new ArrayList<>(record.keySet());
        result.sort(Comparator.reverseOrder());
        for (String name : result) {
            System.out.println(name+" ");
        }
        br.close();
    }
}
