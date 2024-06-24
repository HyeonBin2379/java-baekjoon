package bakjoon.bakjoon24XXX;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise24039 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if (year < 3) {
            System.out.println(6);
            return;
        }
        List<Integer> primeNum = partitionPrimes(year);
        for (int i = 0; i < primeNum.size()-1; i++) {
            int mul = primeNum.get(i)*primeNum.get(i+1);
            if (mul > year) {
                System.out.println(mul);
                break;
            }
        }
    }

    private static boolean isPrime(int year) {
        int yearRoot = (int) Math.sqrt(year);
        return IntStream.rangeClosed(2, yearRoot).noneMatch(i -> year % i == 0);
    }

    private static List<Integer> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(Collectors.partitioningBy(year -> isPrime(year)))
                .get(true);
    }
}
