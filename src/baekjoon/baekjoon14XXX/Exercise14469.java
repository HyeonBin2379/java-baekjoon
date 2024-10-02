package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise14469 {

    private static class Cow implements Comparable<Cow> {
        int arrival, wait;

        public Cow(int arrival, int wait) {
            this.arrival = arrival;
            this.wait = wait;
        }

        @Override
        public int compareTo(Cow o) {
            return this.arrival-o.arrival;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Cow> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int waitTime = Integer.parseInt(st.nextToken());
            queue.add(new Cow(arrival, waitTime));
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            Cow now = queue.poll();
            if (answer <= now.arrival) {
                answer = now.arrival + now.wait;
            } else {
                answer += now.wait;
            }
        }
        System.out.println(answer);
    }
}
