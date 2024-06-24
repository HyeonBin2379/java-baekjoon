package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            int head = Integer.parseInt(br.readLine());
            char[] cmd = br.readLine().toCharArray();
            for (char c : cmd) {
                head = (c == 'c') ? head + 1 : head - 1;
            }
            sb.append(String.format("Data Set %d:\n%d\n", i, Math.max(head, 0))).append("\n");
        }
        System.out.print(sb);
    }
}
