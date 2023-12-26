package bakjoon;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise1759 {
    private static final Set<String> vowels = new HashSet<>(List.of("a", "e", "i", "o", "u"));
    private static String[] letters;
    private static String[] selected;
    private static boolean[] checked;
    private static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        selected = new String[L];
        checked = new boolean[C];
        letters = br.readLine().split(" ", C);
        Arrays.sort(letters);
        br.close();

        getPassword(0);
    }

    public static void getPassword(int level) {
        if (level == L) {
            if (!hasMatchedCondition()) {
                return;
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < L; i++) {
                result.append(selected[i]);
            }
            System.out.println(result);
            return;
        }

        for (int i = 0; i < C; i++) {
            if (!checked[i]) {
                checked[i] = true;
                selected[level] = letters[i];
                if (isPromising(level)) {
                    getPassword(level + 1);
                }
                checked[i] = false;
            }
        }
    }
    private static boolean isPromising(int level) {
        for (int i = 0; i < level; i++) {
            if (selected[i].compareTo(selected[i+1]) >= 0) {
                return false;
            }
        }
        return true;
    }
    private static boolean hasMatchedCondition() {
        int count = (int) Arrays.stream(selected)
                .filter(vowels::contains)
                .count();
        return count > 0 && selected.length-count > 1;
    }
}
