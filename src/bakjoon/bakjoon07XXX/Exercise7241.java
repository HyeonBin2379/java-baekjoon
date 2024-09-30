package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise7241 {

    private static int[] digits;
    private static int sum = 0;
    private static final List<Integer> result = new ArrayList<>();
    private static final boolean[] visited = new boolean[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        digits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int num = Integer.parseInt(br.readLine());
        backtracking(0);
        System.out.println(result.indexOf(num)+1);
    }

    private static void backtracking(int level) {
        if (level == 3) {
            result.add(sum);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sum = (sum*10) + digits[i];
                backtracking(level+1);
                sum /= 10;
                visited[i] = false;
            }
        }
    }
}
