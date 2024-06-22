package bakjoon;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise12101 {

    private static int n;
    private static final Set<String> answerSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int k = sc.nextInt();
        dfs(0, "");
        List<String> result = answerSet.stream().toList();
        System.out.println(result.size() < k ? -1 : String.join("+", result.get(k -1).split("")));
    }

    private static void dfs(int value, String answer) {
        if (value == n) {
            answerSet.add(answer);
        }

        for (int i = 1; i <= 3; i++) {
            if (value <= n-i) {
                dfs(value + i, answer + i);
            }
        }
    }
}
