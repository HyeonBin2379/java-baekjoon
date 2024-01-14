package programmers;

class FindingNextNumberSolution {
    public int solution(int n) {
        int answer = n+1;
        while (!isNextNumber(n, answer)) {
            answer++;
        }
        return answer;
    }

    public boolean isNextNumber(int n, int answer) {
        return Integer.bitCount(n) == Integer.bitCount(answer);
    }
}
public class FindingNextNumber {
    public static void main(String[] args) {
        System.out.println(new FindingNextNumberSolution().solution(78));
    }
}
