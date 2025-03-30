package algorithm.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int now = 1;

        for (int num : sequence) {
            if (num >= now) {
                while (num >= now) {
                    stack.push(now++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                continue;
            }

            if (stack.pop() > num) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
