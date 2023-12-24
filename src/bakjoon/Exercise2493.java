package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Exercise2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tower = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[N];
        br.close();

        Stack<Integer> stack = new Stack<>();
        for (int i = N; i > 0; i--) {
            while (!stack.isEmpty() && tower[i-1] > tower[stack.peek()-1]) {
                answer[stack.pop()-1] = i;
            }
            stack.push(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int j : answer) {
            bw.write(j + " ");
        }
        bw.flush();
        bw.close();
    }
}
