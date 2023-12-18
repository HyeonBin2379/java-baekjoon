package bakjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise2164 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= length; i++) {
            queue.offer(i);
        }
        sc.close();

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
