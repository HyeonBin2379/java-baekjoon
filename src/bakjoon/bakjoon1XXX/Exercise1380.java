package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise1380 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            List<String> confiscated = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = br.readLine();
                confiscated.add(name);
            }

            Map<Integer, Boolean> log = new TreeMap<>();
            for (int i = 0; i < 2*n-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken())-1;
                String data = st.nextToken();
                if (!log.containsKey(index)) {
                    log.put(index, true);
                } else {
                    log.put(index, false);
                }
            }

            for (Integer stuNum : log.keySet()) {
                if (log.get(stuNum)) {
                    sb.append(String.format("%d %s\n", ++count, confiscated.get(stuNum)));
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
