package programmers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class DartGameSolution {
    private final Map<Character, Integer> power = new LinkedHashMap<>(Map.of('S', 1, 'D', 2, 'T', 3));

    public int solution(String dartResult) {
        char[] dart = dartResult.toCharArray();
        List<Integer> numbers = new ArrayList<>();
        StringBuilder num = new StringBuilder();

        for (Character ch : dart) {
            if (Character.isDigit(ch)) {
                num.append(ch);
            } else if (ch == 'S' || ch == 'D' || ch == 'T') {
                numbers.add((int) Math.pow(Integer.parseInt(num.toString()), power.get(ch)));
                num.setLength(0);
            } else {
                if (ch == '*') {
                    numbers.set(numbers.size()-1, numbers.get(numbers.size()-1) * 2);
                    if (numbers.size() > 1) {
                        numbers.set(numbers.size()-2, numbers.get(numbers.size()-2) * 2);
                    }
                } else if (ch == '#') {
                    numbers.set(numbers.size()-1, numbers.get(numbers.size()-1) * (-1));
                }
            }
        }

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
public class DartGame {
    public static void main(String[] args) {
        String dartResult = "1S2D*3T";
        DartGameSolution result = new DartGameSolution();
        System.out.println(result.solution(dartResult));
    }
}
