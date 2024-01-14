package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MaxAndMinSolution {
    public String solution(String s) {
        int[] num = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = new ArrayList<>();
        for (int value : num) {
            numbers.add(value);
        }
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        return min + " " + max;
    }
}
public class MaxAndMin {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(new MaxAndMinSolution().solution(s));
    }
}
