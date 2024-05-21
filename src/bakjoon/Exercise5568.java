package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise5568 {

    private static final Set<String> result = new TreeSet<>();
    private static int n, k;
    private static int[] selected, card;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }

        selected = new int[k];
        visited = new boolean[n];
        combineNum(0);
        System.out.println(result.size());
    }

    private static void combineNum(int step) {
        if (step == k) {
            result.add(Arrays.stream(selected).mapToObj(Integer::toString).collect(Collectors.joining()));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[step] = card[i];
                combineNum(step+1);
                visited[i] = false;
            }
        }
    }
}
