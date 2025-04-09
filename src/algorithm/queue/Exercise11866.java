package algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toCollection(LinkedList::new));
        List<String> result = new ArrayList<>();
        int count = 1;
        while (!queue.isEmpty()) {
            if (count % k != 0) {
                queue.offer(queue.poll());
            } else {
                result.add(Integer.toString(queue.poll()));
            }
            count++;
        }
        System.out.printf("<%s>\n", String.join(", ", result));
    }
}
