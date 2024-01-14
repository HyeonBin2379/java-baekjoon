package programmers;

import java.util.Arrays;
import java.util.Comparator;

class HIndexSolution {
    public int solution(int[] citations) {
        Integer[] sorted = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted, Comparator.reverseOrder());

        Integer[] hIndex = new Integer[sorted.length];
        for (int i = 0; i < citations.length; i++) {
            hIndex[i] = Math.min(countCitations(sorted, sorted[i]), sorted[i]);
        }
        Arrays.sort(hIndex);
        return hIndex[hIndex.length-1];
    }

    public int countCitations(Integer[] citations, int h) {
        return (int) Arrays.stream(citations)
                .filter(value -> value >= h)
                .count();
    }
}
public class HIndex {
    public static void main(String[] args) {
        int[] citation = {3, 0, 6, 1, 5};
        System.out.println(new HIndexSolution().solution(citation));
    }
}
