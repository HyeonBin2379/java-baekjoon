package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class FailRateSolution {
    public int[] solution(int N, int[] stages) {
        int[] stagePassed = new int[N+2];
        for (int stage : stages) {
            stagePassed[stage]++;
        }

        int[] prefixSub = new int[N+2];
        Map<Integer, Double> failRate = new LinkedHashMap<>();
        Arrays.fill(prefixSub, stages.length);
        for (int i = 1; i < N+1; i++) {
            prefixSub[i] = prefixSub[i-1] - stagePassed[i-1];
            if (stagePassed[i] != 0) {
                failRate.put(i, (double) stagePassed[i] / prefixSub[i]);
            } else {
                failRate.put(i, (double) 0);
            }
        }

        List<Integer> sorted = new ArrayList<>(failRate.keySet());
        sorted.sort((o1, o2) -> {
            int comparison = Double.compare(failRate.get(o1), failRate.get(o2));
            if (comparison != 0) {
                return comparison * (-1);
            } else {
                return o1 - o2;
            }
        });

        return sorted.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
public class FailRate {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {1, 1, 1, 2, 3, 4};
        FailRateSolution result = new FailRateSolution();
        System.out.println(Arrays.toString(result.solution(N, stages)));
    }
}
