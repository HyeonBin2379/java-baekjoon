package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class MakingSpicySolution {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = Arrays.stream(scoville).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        while (!queue.isEmpty() && queue.peek() < K) {
            int min1 = queue.poll();
            if (queue.isEmpty()) {
                return -1;
            }
            int min2 = queue.poll();
            queue.add(min1 + (min2 * 2));
            answer++;
        }
        return answer;
    }
}
public class MakingSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(new MakingSpicySolution().solution(scoville, k));
    }
}