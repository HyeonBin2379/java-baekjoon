package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise1039 {

    private static int n, max;
    private static char[] num;
    private static final Map<Integer, Set<Integer>> check = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = st.nextToken().toCharArray();
        n = Integer.parseInt(st.nextToken());

        if (num.length == 1 || (num.length == 2 && num[1] == '0')) {
            System.out.println(-1);
            return;
        }
        IntStream.rangeClosed(0, 10).forEach(idx -> check.put(idx, new HashSet<>()));
        max = 0;
        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int start, int count) {
        if (count == n) {
            int value = Integer.parseInt(new String(num));
            max = Math.max(value, max);
            return;
        }
        for (int i = start; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (i == 0 && num[j] == '0') {
                    continue;
                }
                swap(i, j);

                if (!check.get(count).contains(Integer.parseInt(new String(num)))) {
                    check.get(count).add(Integer.parseInt(new String(num)));
                    dfs(i, count + 1);
                }
                swap(i, j);
            }
        }
    }

    private static void swap(int idx1, int idx2) {
        char temp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = temp;
    }
}
