package programmers;

class TournamentSolution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        while (Math.abs(a-b) != 1 || Math.max(a, b) % 2 != 0) {
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;
        }
        return answer;
    }
}
public class Tournament {
    public static void main(String[] args) {
        System.out.println(new TournamentSolution().solution(8, 4, 7));
    }
}
