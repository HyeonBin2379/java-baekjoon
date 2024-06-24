package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Exercise24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int structCnt = Integer.parseInt(br.readLine());
        int[] structType = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < structCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (structType[i] == 0) {
                deque.addLast(num);
            }
        }

        int inputLength = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < inputLength; i++) {
            int number = Integer.parseInt(st.nextToken());
            deque.addFirst(number);
            bw.write(deque.pollLast() + " ");
        }
        bw.flush();
        bw.close();
    }
}
