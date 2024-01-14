package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class ConcludingRemarkSolution {
    private final Map<Integer, List<String>> wordLog = new TreeMap<>();

    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        initializeWordLog(n);
        for (int i = 0; i < words.length; i++) {
            if (!isMatchedCondition(i, words) || hasContained(words[i])) {
                answer[0] = (i % n) + 1;
                answer[1] = wordLog.get(i % n).size() + 1;
                break;
            }
            wordLog.get(i % n).add(words[i]);
        }
        return answer;
    }

    public void initializeWordLog(int n) {
        for (int i = 0; i < n; i++) {
            wordLog.put(i, new ArrayList<>());
        }
    }
    public boolean isMatchedCondition(int i, String[] words) {
        return i == 0 || words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0);
    }
    public boolean hasContained(String word) {
        return wordLog.entrySet().stream()
                .anyMatch(entry -> entry.getValue().contains(word));
    }
}
public class ConcludingRemark {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(new ConcludingRemarkSolution().solution(n, words)));
    }
}
