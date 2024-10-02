package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Exercise1417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                pq.add(Integer.parseInt(br.readLine()));
            }

            while (!pq.isEmpty() && pq.peek() >= dasom) {
                int now = pq.poll();
                now--;
                dasom++;
                answer++;
                pq.add(now);
            }
        }
        System.out.println(answer);
    }
}
