package programmers;

class NumberExpressionSolution {
    public int solution(int n) {
        int answer = 1;
        int start = 1, end = 1;
        int sum = 1;
        while (end != n) {
            if (sum == n) {
                answer++;
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        return answer;
    }
}
public class NumberExpression {
    public static void main(String[] args) {
        System.out.println(new NumberExpressionSolution().solution(15));
    }
}
