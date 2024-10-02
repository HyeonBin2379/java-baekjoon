package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Exercise16922 {

    private static int n;
    private static final Set<Integer> result = new TreeSet<>();
    private static final int[] num = {1, 5, 10, 50};
    private static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selected = new int[n];
        makeRomanNum(0, 0);
        System.out.println(result.size());
    }

    private static void makeRomanNum(int step, int index) {
        if (step == n) {
            result.add(Arrays.stream(selected).reduce(0, Integer::sum));
            return;
        }
        for (int i = index; i < 4; i++) {
            selected[step] = num[i];
            makeRomanNum(step+1, i);
            selected[step] = 0;
        }
    }
}
