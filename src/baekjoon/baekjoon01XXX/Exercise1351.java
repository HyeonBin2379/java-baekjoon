package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise1351 {

    private static final Map<Long, Long> dp = new TreeMap<>(Map.of(0L, 1L));
    private static long p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        System.out.println(getAnswer(n));
    }

    private static long getAnswer(long index) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }
        long first = getAnswer(index/p);
        long second = getAnswer(index/q);
        dp.put(index, first+second);
        return first + second;
    }
}
