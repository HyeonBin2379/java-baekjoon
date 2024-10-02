package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise31962 {

    private static class Bus implements Comparable<Bus> {
        int s, t;

        public Bus(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Bus o) {
            return o.s-s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Bus> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (s+t <= x) {
                result.add(new Bus(s, t));
            }
        }
        Collections.sort(result);
        System.out.println(result.isEmpty() ? -1 : result.get(0).s);
    }
}
