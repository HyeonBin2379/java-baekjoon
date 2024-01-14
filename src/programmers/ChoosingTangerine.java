package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ChoosingTangerineSolution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> count = new LinkedHashMap<>();
        for (int size : tangerine) {
            count.put(size, count.getOrDefault(size, 0)+1);
        }
        pq.addAll(count.values());

        while (!pq.isEmpty() && k > 0) {
            int num = pq.poll();
            k -= num;
            answer++;
        }
        return answer;
    }
}
public class ChoosingTangerine {
    public static void main(String[] args) {
        int k = 4;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(new ChoosingTangerineSolution().solution(k, tangerine));
    }
}
