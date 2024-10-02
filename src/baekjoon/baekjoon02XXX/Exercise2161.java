package baekjoon.baekjoon02XXX;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Exercise2161 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> deq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deq.addLast(i);
        }

        while (!deq.isEmpty()) {
            int top = deq.pollFirst();
            System.out.print(top + " ");
            if (deq.isEmpty()) {
                break;
            }
            top = deq.pollFirst();
            deq.addLast(top);
        }
    }
}
