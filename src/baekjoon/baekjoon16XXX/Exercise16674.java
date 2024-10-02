package baekjoon.baekjoon16XXX;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise16674 {

    private static final Set<Integer> year2018 = new TreeSet<>(Set.of(2, 0, 1, 8));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Long> input = Arrays.stream(Integer.toString(sc.nextInt()).split(""))
                .collect(Collectors.groupingBy(Integer::parseInt, Collectors.counting()));

        if (year2018.equals(input.keySet())) {
            System.out.println(input.values().stream().distinct().count() == 1 ? 8 : 2);
        } else if (year2018.containsAll(input.keySet())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
