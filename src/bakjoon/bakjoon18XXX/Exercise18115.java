package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Exercise18115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        Deque<Integer> original = new ArrayDeque<>();
        int card = 1;
        for (int i = n-1; i >= 0; i--) {
            switch (cmd[i]) {
                case 1 -> original.addLast(card);
                case 2 -> {
                    Integer temp = original.pollLast();
                    original.addLast(card);
                    original.addLast(temp);
                }
                case 3 -> original.addFirst(card);
            }
            card++;
        }

        StringBuilder answer = new StringBuilder(String.valueOf(original.pollLast()));
        while (!original.isEmpty()) {
            answer.append(" ").append(original.pollLast());
        }
        System.out.println(answer);
    }
}