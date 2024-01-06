package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

class MockExamSolution {
    private final int[][] persons = new int[3][];

    public int[] solution(int[] answers) {
        persons[0] = new int[] {1,2,3,4,5};
        persons[1] = new int[] {2,1,2,3,2,4,2,5};
        persons[2] = new int[] {3,3,1,1,2,2,4,4,5,5};
        Map<Integer, Integer> score = new LinkedHashMap<>();
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == persons[j][i % persons[j].length]) {
                    score.put(j+1, score.getOrDefault(j+1, 0)+1);
                }
            }
        }

        List<Map.Entry<Integer, Integer>> entrySet = new ArrayList<>(score.entrySet());
        entrySet.sort((o1, o2) -> {
            int comparison = Integer.compare(o1.getValue(), o2.getValue()) * (-1);
            return (comparison != 0) ? comparison : o1.getKey()-o2.getKey();
        });
        return entrySet.stream()
                .filter(entry -> Objects.equals(entry.getValue(), Collections.max(score.values())))
                .mapToInt(Entry::getKey)
                .toArray();
    }
}
public class MockExam {
    public static void main(String[] args) {
        int[] answers = {1,1,1,1,1,1};
        System.out.println(Arrays.toString(new MockExamSolution().solution(answers)));
    }
}
