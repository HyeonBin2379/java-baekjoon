package baekjoon.baekjoon30XXX;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise30924 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        List<Integer> numbers = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        while (true) {
            a = numbers.get(0);
            numbers.remove(0);
            System.out.println("? A " + a);

            int answer = sc.nextInt();
            if (answer == 1) {
                break;
            }
        }

        int b;
        numbers = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        while (true) {
            b = numbers.get(0);
            numbers.remove(0);
            System.out.println("? B " + b);

            int answer = sc.nextInt();
            if (answer == 1) {
                break;
            }
        }
        System.out.println("! " + (a + b));
    }
}