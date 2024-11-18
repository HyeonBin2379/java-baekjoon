package baekjoon.baekjoon32XXX;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise32651 {

    private static final List<Integer> numList = getList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(numList.contains(num) ? "Yes" : "No");
    }

    private static List<Integer> getList() {
        return IntStream.rangeClosed(1, 100000)
                .filter(num -> num % 2024 == 0)
                .boxed()
                .collect(Collectors.toList());
    }
}
