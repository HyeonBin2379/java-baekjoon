package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise31860 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> d = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            d.offer(Long.parseLong(br.readLine()));
        }

        List<Long> result = new ArrayList<>();
        long prev = 0;
        while (!d.isEmpty()) {
            long value = d.poll();
            if (value <= k) {
                continue;
            }
            long next = prev/2 + value;
            prev = next;
            result.add(next);
            d.offer(value-m);
        }

        sb.append(result.size()).append("\n");
        result.forEach(v -> sb.append(v).append("\n"));
        System.out.print(sb);
    }
}
