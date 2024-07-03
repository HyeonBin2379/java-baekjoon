package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Exercise3407 {

    private static String input;
    private static boolean[] visited;

    private static final Set<String> element = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        initSet();
        for (int i = 0; i < testcase; i++) {
            input = br.readLine();
            visited = new boolean[input.length()];
            bfs(input.length());
        }
    }

    private static void initSet() {
        String[] list = { "h", "b", "c", "n", "o", "f", "p", "s", "k", "v", "y", "i", "w", "u", "ba",
                "ca", "ga", "la", "na", "pa", "ra", "ta", "db", "nb", "pb", "rb", "sb", "tb", "yb", "ac", "sc", "tc",
                "cd", "gd", "md", "nd", "pd", "be", "ce", "fe", "ge", "he", "ne", "re", "se", "te", "xe", "cf", "hf",
                "rf", "ag", "hg", "mg", "rg", "sg", "bh", "rh", "th", "bi", "li", "ni", "si", "ti", "bk", "al", "cl",
                "fl", "tl", "am", "cm", "fm", "pm", "sm", "tm", "cn", "in", "mn", "rn", "sn", "zn", "co", "ho", "mo",
                "no", "po", "np", "ar", "br", "cr", "er", "fr", "ir", "kr", "lr", "pr", "sr", "zr", "as", "cs", "ds",
                "es", "hs", "os", "at", "mt", "pt", "au", "cu", "eu", "lu", "pu", "ru", "lv", "dy" };
        element.addAll(Arrays.asList(list));
    }
    private static void bfs(int len) {
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= 2; i++) {
                int next = now + i;

                if (next <= len && element.contains(input.substring(now, next))) {
                    if (next == len) {
                        System.out.println("YES");
                        return;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        System.out.println("NO");
    }
}
