package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Exercise1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < testCase; i++) {
            int cards = Integer.parseInt(br.readLine());
            pq.add(cards);
        }
        br.close();

        int result = 0;
        while (pq.size() > 1) {
            Integer data1 = pq.poll();
            Integer data2 = pq.poll();
            int temp = data1 + data2;
            result += temp;
            pq.add(temp);
        }
        System.out.println(result);
    }
}
