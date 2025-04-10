package baekjoon.baekjoon15XXX;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise15659 {

    private static final Set<String> answer = new LinkedHashSet<>();

    private static int n, m;
    private static int[] input, selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());
        m = Integer.parseInt(sc.nextLine().trim());

        input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        selected = new int[n];
        backtracking(0, 0);
        answer.forEach(System.out::println);
    }

    private static void backtracking(int count, int start) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            answer.add(sb.toString().trim());
            return;
        }
        for (int i = start; i < n; i++) {
            selected[count] = input[i];
            backtracking(count+1, i+1);
            selected[count] = 0;
        }
    }
}
