package programmers;

class NBaseGameSolution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder numString = new StringBuilder();
        int number = 0;
        while (numString.length() < t * m) {
            numString.append(Integer.toString(number++, n));
        }
        numString = new StringBuilder(numString.substring(0, t * m));
        for (int i = 0; i < numString.length(); i++) {
            if (i % m == (p-1)) {
                answer.append(numString.charAt(i));
            }
        }
        return answer.toString().toUpperCase();
    }
}
public class NBaseGame {
    public static void main(String[] args) {
        System.out.println(new NBaseGameSolution().solution(2, 4, 2, 1));
    }
}
