package bakjoon.bakjoon07XXX;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Exercise7181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Integer[] num = Arrays.stream(sc.nextLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);
        int testCase = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCase; i++) {
            Set<Integer> numSet = new HashSet<>(Arrays.asList(num));
            Integer[] input = Arrays.stream(sc.nextLine().split("")).map(Integer::parseInt).toArray(Integer[]::new);
            int a = 0, b = 0;
            for (int j = 0; j < 4; j++) {
                a += (numSet.contains(input[j])) ? 1 : 0;
                b += (Objects.equals(num[j], input[j])) ? 1 : 0;
            }
            sb.append(String.format("%d %d\n", a, b));
        }
        System.out.print(sb);
    }
}
