package programmers;

import java.util.Arrays;
import java.util.Stack;

class MaximumRightNumberSolution {
    private final Stack<Integer> stack = new Stack<>();

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}

public class MaximumRightNumber {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5};
        System.out.println(Arrays.toString(new MaximumRightNumberSolution().solution(numbers)));
    }
}
