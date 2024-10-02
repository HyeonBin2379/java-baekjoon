package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise3015 {
    private static int count;
    private static int[] height;

    private static class Pair {
        int height, count;
        Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());
        height = new int[count];
        for (int i = 0; i < count; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        System.out.println(getBuildingCount());
    }

    public static long getBuildingCount() {
        Stack<Pair> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < count; i++) {
            Pair pair = new Pair(height[i], 1);
            // 자신(height[i])보다 키가 작거나 같으면 stack에서 pop
            // 자신보다 키 큰 사람을 만날 때까지 pop
            while (!stack.isEmpty() && stack.peek().height <= height[i]) {
                Pair popped = stack.pop();
                result += popped.count;
                if (popped.height == height[i]) {
                    pair.count += popped.count;
                }
            }
            // stack에 저장된, 자신보다 키 큰 사람
            if (!stack.isEmpty()) {
                result++;
            }
            stack.push(pair);
        }
        return result;
    }
}
