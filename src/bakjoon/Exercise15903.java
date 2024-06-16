package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise15903 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        PriorityQueue<Long> pq = Arrays.stream(br.readLine().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(PriorityQueue::new));

        for (int i = 0; i < m; i++) {
            Long num1 = pq.poll();
            Long num2 = pq.poll();

            for (int j = 0; j < 2; j++) {
                pq.add(num1 + num2);
            }
        }
        System.out.println(pq.stream().reduce(0L, Long::sum));
    }
}
