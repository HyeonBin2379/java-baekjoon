package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Exercise2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Deque<Integer> stack = new ArrayDeque<>();
        int[] receiver = new int[n];
        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && height[i-1] > height[stack.peek()-1]) {
                receiver[stack.pop()-1] = i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.stream(receiver).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}
