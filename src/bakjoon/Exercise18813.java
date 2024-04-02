package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise18813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String[] word = br.readLine().split("");
            Set<String> letter = Arrays.stream(word).collect(Collectors.toCollection(TreeSet::new));
            if (word.length == letter.size() && !notMatched(letter, m)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean notMatched(Set<String> letter, int m) {
        return letter.stream()
                .anyMatch(s -> s.charAt(0) >= 'A'+m);
    }
}
