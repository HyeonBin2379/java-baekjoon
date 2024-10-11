package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise2109 {

    private static class Course implements Comparable<Course>{
        int price, deadline;

        public Course(int price, int deadline) {
            this.price = price;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Course o) {
            return this.deadline != o.deadline
                    ? Integer.compare(this.deadline, o.deadline)
                    : Integer.compare(this.price, o.price);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Course> input = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            input.add(new Course(price, deadline));
        }
        Collections.sort(input);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(input.get(i).price);
            if (pq.size() > input.get(i).deadline) {
                pq.poll();
            }
        }

        long answer = 0L;
        while (!pq.isEmpty()) {
            answer += pq.peek();
            pq.poll();
        }
        System.out.println(answer);
    }
}
