package algorithm.backtracking;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise15665 {

    private static final Set<String> answer = new LinkedHashSet<>();

    private static int n, m;
    private static int[] input, selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.next());
        m = Integer.parseInt(sc.nextLine().trim());

        input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        selected = new int[m];
        backtracking(0);
        answer.forEach(System.out::println);
    }

    private static void backtracking(int count) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(" ");
            }
            answer.add(sb.toString().trim());
            return;
        }
        for (int i = 0; i < n; i++) {
            selected[count] = input[i];
            backtracking(count+1);
        }
    }
}
