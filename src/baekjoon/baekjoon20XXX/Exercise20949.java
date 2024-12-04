package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise20949 {

    private static class Monitor implements Comparable<Monitor> {
        double ppi;
        int num;

        public Monitor(double ppi, int num) {
            this.ppi = ppi;
            this.num = num;
        }

        @Override
        public int compareTo(Monitor o) {
            return this.ppi != o.ppi ? Double.compare(o.ppi, this.ppi) : Integer.compare(this.num, o.num);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Monitor> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            double ppi = Math.sqrt(w*w + h*h)/77;
            result.add(new Monitor(ppi, i));
        }
        Collections.sort(result);
        result.stream().map(monitor -> monitor.num).forEach(System.out::println);
    }
}
