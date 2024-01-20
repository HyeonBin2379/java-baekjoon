package programmers;

import java.util.HashSet;
import java.util.Set;

class FindingPrimeNumberSolution {
    private boolean[] visited;
    private final Set<Integer> primeNumber = new HashSet<>();
    private String[] token;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        token = numbers.split("");
        backtracking(0, "");
        return primeNumber.stream()
                .filter(this::isPrimeNumber)
                .toList()
                .size();
    }

    public void backtracking(int index, String num) {
        if (!num.isEmpty()) {
            primeNumber.add(Integer.parseInt(num));
        }

        for (int i = 0; i < token.length; i++) {
            if (!visited[i]) {
                visited[i] = true; //상태변화
                backtracking(index + 1, num + token[i]);
                visited[i] = false; //원상복구
            }
        }
    }

    public boolean isPrimeNumber(Integer num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
public class FindingPrimeNumber {
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(new FindingPrimeNumberSolution().solution(numbers));
    }
}
