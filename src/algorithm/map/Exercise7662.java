package algorithm.map;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise7662 {

    private static final TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            map.clear();
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (cmd) {
                    case "I" -> {
                        if (map.containsKey(num)) {
                            map.merge(num, 1, Integer::sum);
                        } else {
                            map.put(num, 1);
                        }
                    }
                    case "D" -> {
                        if (!map.isEmpty()) {
                            delete(num);
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
                continue;
            }
            bw.write(map.lastKey() + " " + map.firstKey() + "\n");
        }
        br.close();
        bw.close();
    }

    private static void delete(int num) {
        Entry<Integer, Integer> entry = (num == 1) ? map.lastEntry() : map.firstEntry();

        if (entry.getValue() <= 1) {
            map.remove(entry.getKey());
            return;
        }
        map.merge(entry.getKey(), -1, Integer::sum);
    }
}
