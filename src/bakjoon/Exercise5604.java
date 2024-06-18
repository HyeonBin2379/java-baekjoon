package bakjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise5604 {

    private static final List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        dfs(n, n, new ArrayList<>());

        result.sort((a, b) -> {
            int len = Math.min(a.size(), b.size());
            for (int i = 0; i < len; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return b.get(i) - a.get(i);
                }
            }
            return b.size() - a.size();
        });
        for (List<Integer> list : result) {
            System.out.println(list.stream()
                    .map(value -> Integer.toString(value))
                    .collect(Collectors.joining(" ")));
        }
    }

    private static void dfs(int n, int max, List<Integer> current) {
        if (n == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = Math.min(n, max); i >= 1; i--) {
            current.add(i);
            dfs(n-i, i, current);
            current.remove(current.size()-1);
        }
    }
}
