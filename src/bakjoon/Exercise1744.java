package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Exercise1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0, zero = 0;
        for (int i = 0; i < numCount; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 1) {
                one++;
            } else if (value == 0) {
                zero++;
            } else if (value > 0) {
                plusPq.add(value);
            } else {
                minusPq.add(value);
            }
        }
        br.close();

        int sum = 0;
        while (plusPq.size() > 1) {
            Integer first = plusPq.poll();
            Integer second = plusPq.poll();
            sum += first * second;
        }
        if (plusPq.size() > 0) {
            sum += plusPq.poll();
        }

        while (minusPq.size() > 1) {
            Integer first = minusPq.poll();
            Integer second = minusPq.poll();
            sum += first * second;
        }
        if (minusPq.size() > 0) {
            if (zero == 0) {
                sum += minusPq.poll();
            }
        }
        sum += one;
        System.out.println(sum);
    }
}
