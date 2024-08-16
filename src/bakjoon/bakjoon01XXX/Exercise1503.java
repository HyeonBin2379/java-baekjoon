package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < m; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> nonS = IntStream.rangeClosed(1, 1001)
                .boxed()
                .filter(i -> !s.contains(i))
                .toList();

        long min = Long.MAX_VALUE;
        for (Integer i : nonS) {
            for (Integer j : nonS) {
                for (Integer k : nonS) {
                    int product = i*j*k;
                    min = Math.min(Math.abs(n - product), min);
                    if (n+1 < product) {
                        break;
                    }
                }
            }
        }
        System.out.println(min);
    }
}