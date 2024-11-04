package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise11502 {

    private static final List<Integer> primeNum = findPrimeNumber();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            List<Integer> temp = primeNum.stream().takeWhile(num -> num <= number).sorted().collect(Collectors.toList());
            List<Integer> answer = new ArrayList<>();

            for (int a = 0; a < temp.size(); a++) {
                for (int b = a; b < temp.size(); b++) {
                    for (int c = b; c < temp.size(); c++) {
                        if (temp.get(a) + temp.get(b) + temp.get(c) == number) {
                            answer = Arrays.asList(temp.get(a), temp.get(b), temp.get(c));
                            Collections.sort(answer);
                            break;
                        }
                    }
                }
            }

            if (answer.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(answer.stream()
                        .map(num -> Integer.toString(num))
                        .collect(Collectors.joining(" ")));
            }
        }
    }

    private static List<Integer> findPrimeNumber() {
        boolean[] notPrime = new boolean[1001];
        for (int i = 2; i*i <= 1000; i++) {
            if (notPrime[i]) {
                continue;
            }
            for (int j = i*i; j <= 1000; j += i) {
                notPrime[j] = true;
            }
        }
        return IntStream.rangeClosed(2, 1000)
                .filter(num -> !notPrime[num])
                .boxed()
                .collect(Collectors.toList());
    }
}
