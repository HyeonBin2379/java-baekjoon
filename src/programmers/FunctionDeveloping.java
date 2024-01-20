package programmers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class FunctionDevelopingSolution {
    private final Map<Integer, Integer> result = new LinkedHashMap<>();

    public int[] solution(int[] progresses, int[] speeds) {
        int[] period = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] < 100) {
                progresses[i] += speeds[i];
                period[i]++;
            }
        }

        int max = period[0];
        for (int j : period) {
            max = Math.max(max, j);
            result.put(max, result.getOrDefault(max, 0) + 1);
        }
        return result.values().stream()
                .mapToInt(value -> value)
                .toArray();
    }
}
public class FunctionDeveloping {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(new FunctionDevelopingSolution().solution(progresses, speeds)));
    }
}
