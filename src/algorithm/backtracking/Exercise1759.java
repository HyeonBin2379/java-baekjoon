package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise1759 {

    private static final Set<String> vowels = Set.of("a", "e", "i", "o", "u");
    private static final StringBuilder sb = new StringBuilder();

    private static int l, c;
    private static String[] input, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        input = br.readLine().split(" ");
        Arrays.sort(input);

        selected = new String[l];
        backtracking(0, 0);
        System.out.println(sb);
    }

    private static void backtracking(int count, int start) {
        if (count == l) {
            if (isPossible(selected)) {
                sb.append(String.join("", selected)).append("\n");
            }
            return;
        }
        for (int i = start; i < c; i++) {
            selected[count] = input[i];
            backtracking(count + 1, i + 1);
            selected[count] = "";
        }
    }
    private static boolean isPossible(String[] selected) {
        int vCnt = (int) Arrays.stream(selected).filter(vowels::contains).count();

        return vCnt >= 1 && (selected.length-vCnt) >= 2;
    }
}
