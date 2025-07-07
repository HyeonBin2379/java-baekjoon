package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise1202 {

    static class Jewel implements Comparable<Jewel> {
        long weight;
        long value;

        public Jewel(long weight, long value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            return this.value != o.value
                    ? Long.compare(o.value, this.value)
                    : Long.compare(this.weight, o.weight);
        }
    }

    private static final List<Jewel> list = new ArrayList<>();
    private static final TreeMap<Long, Long> bag = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());
            long v = Long.parseLong(st.nextToken());
            list.add(new Jewel(m, v));
        }
        Collections.sort(list);

        for (int i = 0; i < k; i++) {
            long capacity = Long.parseLong(br.readLine());
            bag.merge(capacity, 1L, Long::sum);
        }

        long answer = 0;
        for (Jewel jewel : list) {
            if (bag.ceilingKey(jewel.weight) != null) {
                long weight = bag.ceilingKey(jewel.weight);
                if (bag.get(weight) > 1) {
                    bag.merge(weight, -1L, Long::sum);
                } else {
                    bag.remove(weight);
                }
                answer += jewel.value;
            }
        }
        System.out.println(answer);
    }
}
