package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10819 {

    private static int answer;
    private static int[] numbers, selected;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        selected = new int[n];
        visited = new boolean[n];
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int count) {
        if (count == numbers.length) {
            int total = 0;
            for (int i = 0; i < numbers.length-1; i++) {
                total += Math.abs(selected[i]-selected[i+1]);
            }
            answer = Math.max(total, answer);
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                selected[count] = numbers[i];
                visited[i] = true;
                backtracking(count+1);
                visited[i] = false;
            }
        }
    }
}
