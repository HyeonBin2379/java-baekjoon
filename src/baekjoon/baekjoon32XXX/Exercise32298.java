package baekjoon.baekjoon32XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise32298 {

    private static final List<Integer> primeNum = findPrimeNum();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= d*n; i++) {
            for (int j = i; j < d*n+i; j += d) {
                if (primeNum.contains(j)) {
                    answer.clear();
                    break;
                }
                answer.add(j);
            }
            if (answer.size() == n) {
                System.out.println(answer.stream().map(value -> Integer.toString(value)).collect(Collectors.joining(" ")));
                return;
            }
        }
        System.out.println(-1);
    }

    private static List<Integer> findPrimeNum() {
        boolean[] isNotPrime = new boolean[2000001];
        for (int i = 2; i*i <= 2000000; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i*i; j <= 2000000; j += i) {
                isNotPrime[j] = true;
            }
        }
        return IntStream.range(2, isNotPrime.length)
                .filter(i -> !isNotPrime[i])
                .boxed()
                .collect(Collectors.toList());
    }
}
