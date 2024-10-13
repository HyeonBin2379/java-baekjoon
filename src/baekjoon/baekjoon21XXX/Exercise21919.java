package baekjoon.baekjoon21XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise21919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> num = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toList();
        List<Integer> primeNum = getPrimeNumbers(num.get(n - 1));

        Set<Long> prime = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (primeNum.contains(num.get(i))) {
                prime.add(Long.valueOf(num.get(i)));
            }
        }
        long answer = prime.stream().reduce(1L, (a, b) -> a*b);
        System.out.println(answer == 1L ? -1 : answer);
    }

    private static List<Integer> getPrimeNumbers(int maxNum) {
        boolean[] isNotPrime = new boolean[maxNum+1];

        for (int i = 2; i*i <= maxNum; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i*i; j <= maxNum; j += i) {
                isNotPrime[j] = true;
            }
        }
        return IntStream.rangeClosed(2, maxNum)
                .filter(value -> !isNotPrime[value])
                .boxed()
                .collect(Collectors.toList());
    }
}
