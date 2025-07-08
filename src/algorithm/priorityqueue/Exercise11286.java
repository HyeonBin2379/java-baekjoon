package algorithm.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Exercise11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (o1, o2) -> Math.abs(o1) != Math.abs(o2) ? Integer.compare(Math.abs(o1), Math.abs(o2)) : Integer.compare(o1, o2)
        );
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            } else {
                pq.add(num);
            }
        }
    }
}
