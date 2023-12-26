package bakjoon;

import java.util.Scanner;
import java.util.Stack;

public class Exercise6198 {
    private static int count;
    private static int[] height;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();
        height = new int[count];
        for (int i = 0; i < count; i++) {
            height[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(getBuildingCount());
    }

    public static long getBuildingCount() {
        Stack<Integer> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < count; i++) {
            while (!stack.isEmpty() && stack.peek() <= height[i]) {
                stack.pop();
            }
            stack.push(height[i]);
            result += stack.size()-1;
        }
        return result;
    }
}
