package programmers;

import java.util.Stack;

class MakingBigNumberSolution {
    public String solution(String number, int k) {
        String[] digits = number.split("");
        Stack<String> answer = new Stack<>();

        answer.add(digits[0]);
        for (int i = 1; i < digits.length; i++) {
            while (!answer.isEmpty() &&
                    Integer.parseInt(answer.peek()) < Integer.parseInt(digits[i]) && k > 0) {
                k--;
                answer.pop();
            }
            answer.add(digits[i]);
        }

        String result = String.join("", answer);
        return (result.equals(number) ? result.substring(0, result.length()-k) : result);
    }
}

public class MakingBigNumber {
    public static void main(String[] args) {
        String number = "333222111";
        int k = 4;
        System.out.println(new MakingBigNumberSolution().solution(number, k));
    }
}
