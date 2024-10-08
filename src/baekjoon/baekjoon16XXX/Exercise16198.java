package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise16198 {

    private static int answer;
    private static List<Integer> weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        weight = Arrays.stream(br.readLine().split(" ", n)).map(Integer::parseInt).collect(Collectors.toList());
        backtracking(0);
        System.out.println(answer);
    }

    private static void backtracking(int total) {
        if (weight.size() == 2) {
            answer = Math.max(total, answer);
            return;
        }
        for (int i = 1; i < weight.size()-1; i++) {
            int prev = weight.get(i-1);
            int next = weight.get(i+1);
            int temp = weight.remove(i);
            backtracking(total + prev*next);
            weight.add(i, temp);
        }
    }
}
