package algorithm.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise2164 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> queue = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        while (queue.size() > 1) {
            queue.poll();
            if (queue.size() == 1) {
                break;
            }
            queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
