package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Exercise14225 {

    private static int n;
    private static int[] num;
    private static boolean[] selected;
    private static final Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        selected = new boolean[n];
        selectNum(0);

        int answer = 1;
        while (true) {
            if (!set.contains(answer)) {
                System.out.println(answer);
                return;
            }
            answer++;
        }
    }

    private static void selectNum(int step) {
        if (step == n) {
            set.add(getSum());
            return;
        }
        selected[step] = true;
        selectNum(step+1);
        selected[step] = false;
        selectNum(step+1);
    }

    private static int getSum() {
        return IntStream.range(0, n)
                .filter(i -> selected[i])
                .map(i -> num[i])
                .sum();
    }
}
