package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Exercise17299 {
    private static final Map<Integer, Integer> countByNumber = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] numbers = new int[length];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            countByNumber.put(numbers[i], countByNumber.getOrDefault(numbers[i], 0) + 1);
        }
        br.close();

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[length];
        Arrays.fill(answer, -1);
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && countByNumber.get(numbers[stack.peek()]) < countByNumber.get(numbers[i])) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < length; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
