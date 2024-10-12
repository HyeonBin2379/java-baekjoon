package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise17509 {

    private static class Problem implements Comparable<Problem> {
        int d, v;

        public Problem(int d, int v) {
            this.d = d;
            this.v = v;
        }

        @Override
        public int compareTo(Problem o) {
            return Integer.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Problem(d, v));
        }

        int sum = 0;
        int time = 0;
        while (!pq.isEmpty()) {
            Problem p = pq.poll();
            time += p.d;
            sum += time + p.v * 20;
        }
        System.out.println(sum);
    }
}
