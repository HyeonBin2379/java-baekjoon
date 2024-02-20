package programmers;

import java.util.Arrays;
import java.util.TreeMap;

class DoublyPriorityQueueSolution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        for (String operation : operations) {
            String[] input = operation.split(" ");
            int n = Integer.parseInt(input[1]);
            if (input[0].equals("I")) {
                queue.put(n, queue.getOrDefault(n, 0) + 1);
                continue;
            }

            if (!queue.isEmpty()) {
                int num = (n == 1) ? queue.lastKey() : queue.firstKey();
                if (queue.get(num) > 1) {
                    queue.put(num, queue.get(num) - 1);
                } else {
                    queue.remove(num);
                }
            }
        }

        if (!queue.isEmpty()) {
            answer[0] = queue.lastKey();
            answer[1] = queue.firstKey();
        }
        return answer;
    }
}
public class DoublyPriorityQueue {
    public static void main(String[] args) {
        String[] operation = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(new DoublyPriorityQueueSolution().solution(operation)));
    }
}
