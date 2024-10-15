package baekjoon.baekjoon32XXX;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise32172 {

    private static final Set<Integer> numbers = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = 0;
        for (int i = 1; i <= n; ++i) {
            numbers.add(A);
            A = (A-i < 0 || numbers.contains(A-i)) ? A+i : A-i;
        }
        System.out.println(A);
    }
}
