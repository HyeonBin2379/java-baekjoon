package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise2910 {
    private static final Map<Integer, Integer> numCount = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num <= C) {
                numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        List<Map.Entry<Integer, Integer>> entrySet = new ArrayList<>(numCount.entrySet());
        entrySet.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(" ");
            }
        }
        System.out.println(sb);
    }
}
