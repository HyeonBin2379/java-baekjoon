package programmers;

import java.util.Stack;

class OneTwoFourLandSolution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] num = {1, 2, 4};
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            n -= 1;
            stack.push(num[n % 3]);
            n /= 3;
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.toString();
    }
}
public class OneTwoFourLand {
    public static void main(String[] args) {
        System.out.println(new OneTwoFourLandSolution().solution(10));
    }
}
