package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindingPrimeNumber2Solution {
    private final List<Long> primeNumbers = new ArrayList<>();

    public int solution(int n, int k) {
        String nBase = Integer.toString(n, k);
        Long[] numbers = Arrays.stream(nBase.split("0"))
                .filter(s -> s.length() > 0)
                .map(Long::parseLong).toArray(Long[]::new);
        for (Long number : numbers) {
            if (isPrimeNumber(number)) {
                primeNumbers.add(number);
            }
        }
        return primeNumbers.size();
    }

    private boolean isPrimeNumber(Long num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; (long) i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
public class FindingPrimeNumber2 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(new FindingPrimeNumber2Solution().solution(n, k));
    }
}
