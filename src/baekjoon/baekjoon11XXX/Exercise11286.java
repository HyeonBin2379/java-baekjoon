package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Exercise11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int comparison = Math.abs(o1)-Math.abs(o2);
            return (comparison != 0) ? comparison : o1-o2;
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < inputCount; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                int result = (queue.isEmpty()) ? 0 : queue.poll();
                sb.append(result).append("\n");
            }
            else {
                queue.add(request);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
