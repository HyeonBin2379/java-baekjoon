package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Exercise2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                pq.offer(temp[j]);
            }
        }
        br.close();
        Integer result = 0;
        for (int i = size; i > 0; i--) {
            result = pq.poll();
        }
        System.out.println(result);
    }
}
