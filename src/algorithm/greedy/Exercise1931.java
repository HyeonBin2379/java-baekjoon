package algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise1931 {

    static class Schedule implements Comparable<Schedule> {
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            return this.end != o.end
                    ? Integer.compare(this.end, o.end)
                    : Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Schedule> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Schedule(start, end));
        }

        int answer = 0;
        int lastEnd = 0;
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                Schedule s = pq.poll();
                // 회의 시작 시간이 마지막 회의 종료시간과 같거나 나중일 때
                if (lastEnd <= s.start) {
                    answer++;           // 현재 회의를 진행하고 회의 횟수 1 증가
                    lastEnd = s.end;
                }
            }
        }
        System.out.println(answer);
    }
}
