package algorithm.deque;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercise1021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] input = new int[m];
        for (int i = 0; i < m; i++) {
            input[i] = sc.nextInt();
        }
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            int target = input[i];
            int size = deque.size();
            int index = deque.indexOf(target);

            if (index <= size/2) {
                count += index;
                for (int j = 0; j < index; j++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                count += (size - index);
                for (int j = 0; j < size-index; j++) {
                    deque.addFirst(deque.pollLast());
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
