package programmers;

class TargetNumberSolution {
    private final char[] operation = {'+', '-'};
    private char[] selected;
    private int answer;

    public int solution(int[] numbers, int target) {
        selected = new char[numbers.length];
        backtracking(0, numbers, target);
        return answer;
    }

    public void backtracking(int step, int[] numbers, int target) {
        if (step == numbers.length) {
            int num = 0;
            for (int i = 0; i < selected.length; i++) {
                num += (selected[i] == '+') ? numbers[i] : -numbers[i];
            }
            answer += (num == target) ? 1 : 0;
            return;
        }

        for (char c : operation) {
            selected[step] = c;
            backtracking(step + 1, numbers, target);
        }
    }
}
public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new TargetNumberSolution().solution(numbers, target));
    }
}
