package bakjoon;

import java.util.Scanner;
import java.util.Stack;

public class Exercise1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] sequence = new int[length];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;

        for (int j : sequence) {
            if (j >= num) {
                while (j >= num) {
                    stack.push(num);
                    num++;
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                int popped = stack.pop();
                if (popped > j) {
                    sb.setLength(0);
                    sb.append("NO").append("\n");
                    break;
                } else {
                    sb.append("-").append("\n");
                }
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
