package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise16943 {

    private static final List<String> results = new ArrayList<>();

    private static boolean[] visited;
    private static String a, b;
    private static String[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = st.nextToken();

        visited = new boolean[a.length()];
        num = a.split("");
        Arrays.sort(num);
        dfs(0, "");
        System.out.println(results.stream()
                .map(Integer::parseInt)
                .reduce(-1, Integer::max));
    }

    private static void dfs(int count, String numString) {
        if (count == num.length) {
            if (numString.charAt(0) != '0' && Integer.parseInt(numString) < Integer.parseInt(b)) {
                results.add(numString);
            }
            return;
        }
        for (int i = 0; i < a.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(count+1, numString+num[i]);
                visited[i] = false;
            }
        }
    }
}
