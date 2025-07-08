package algorithm.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Exercise1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.offer(num);
        }

        long answer = 0;
        if (n >= 2) {
            while (!pq.isEmpty() && pq.size() >= 2) {
                int num1 = pq.poll();
                int num2 = pq.poll();

                answer += (num1 + num2);
                if (pq.isEmpty()) {
                    break;
                }
                pq.offer(num1 + num2);
            }
        }
        System.out.println(answer);
    }
}
