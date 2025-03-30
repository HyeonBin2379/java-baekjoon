package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise2170 {

    static class Line implements Comparable<Line> {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return this.start != o.start
                    ? Long.compare(this.start, o.start)
                    : Long.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Line> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Line(start, end));
        }

        long answer = 0;
        int lastStart = (int)-1e9;
        int lastEnd = (int)-1e9;
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                Line line = pq.poll();
                if (line.start > lastEnd) {
                    answer += lastEnd-lastStart;
                    lastStart = line.start;
                    lastEnd = line.end;
                } else {
                    lastEnd = Math.max(line.end, lastEnd);
                }
            }
        }
        answer += lastEnd-lastStart;
        System.out.println(answer);
    }
}
