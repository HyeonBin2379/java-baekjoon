package programmers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

class MemorialScoreSolution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameByYearning = new LinkedHashMap<>();
        for (int i = 0; i < name.length; i++) {
            nameByYearning.put(name[i], yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                if (nameByYearning.containsKey(photo[i][j])) {
                    answer[i] += nameByYearning.get(photo[i][j]);
                }
            }
        }
        return answer;
    }
}
public class MemorialScore {
    public static void main(String[] args) {
        MemorialScoreSolution result = new MemorialScoreSolution();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        System.out.println(Arrays.toString(result.solution(name, yearning, photo)));
    }
}
