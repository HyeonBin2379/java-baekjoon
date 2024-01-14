package programmers;

import java.util.Stack;

class ParingAndRemovingSolution {
    private final Stack<Character> stack = new Stack<>();

    public int solution(String s) {
        for (char ch : s.toCharArray()) {
            stack.push(ch);
            if (stack.size() >= 2 && isContinuous()) {
                removePair();
            }
        }
        return (stack.isEmpty()) ? 1 : 0;
    }

    public boolean isContinuous() {
        return stack.get(stack.size()-1) == stack.get(stack.size()-2);
    }

    public void removePair() {
        for (int i = 0; i < 2; i++) {
            stack.pop();
        }
    }
}

public class ParingAndRemoving {
    public static void main(String[] args) {
        System.out.println(new ParingAndRemovingSolution().solution("baabaa"));
    }
}
