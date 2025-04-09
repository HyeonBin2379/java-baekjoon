package algorithm.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Exercise24511 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mode = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] currentList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());
        int[] inserted = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();

        StringBuilder answer = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (mode[i] == 0) {
                deque.addFirst(currentList[i]);
            }
        }
        for (int i = 0; i < m; i++) {
            deque.add(inserted[i]);
            answer.append(deque.pollFirst()).append(" ");
        }
        System.out.println(answer);
    }
}
