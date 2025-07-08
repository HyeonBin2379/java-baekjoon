package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Exercise13975 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = Arrays.stream(br.readLine().split(" ", n))
                    .map(Long::parseLong)
                    .collect(Collectors.toCollection(PriorityQueue::new));

            long answer = 0;
            while (!pq.isEmpty() && pq.size() >= 2) {
                long num1 = pq.poll();
                long num2 = pq.poll();

                answer += (num1+num2);
                if (pq.isEmpty()) {
                    break;
                }
                pq.offer(num1+num2);
            }
            System.out.println(answer);
        }
    }
}
