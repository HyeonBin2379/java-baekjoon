package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ParsingNSquareSolution {
    public int[] solution(int n, long left, long right) {
        List<Integer> result = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            int row = (int) (i / (long) n);
            int col = (int) (i % (long) n);
            result.add(Math.max(row+1, col+1));
        }
        return result.stream().mapToInt(value -> value).toArray();
    }
}

public class ParsingNSquare {
    public static void main(String[] args) {
        int n = 3;
        int left = 2;
        int right = 5;
        System.out.println(Arrays.toString(new ParsingNSquareSolution().solution(n, left, right)));
    }
}