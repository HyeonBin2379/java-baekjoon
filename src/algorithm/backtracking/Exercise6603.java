package algorithm.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise6603 {

    private static final StringBuilder sb = new StringBuilder();

    private static int n;
    private static int[] numbers, selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            selected = new int[6];
            backtracking(0, 0);
            sb.append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.close();
    }

    private static void backtracking(int level, int start) {
        if (level == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            selected[level] = numbers[i];
            backtracking(level+1, i+1);
            selected[level] = 0;
        }
    }
}
