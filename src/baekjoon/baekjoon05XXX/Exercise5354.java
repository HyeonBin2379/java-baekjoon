package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5354 {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int size = Integer.parseInt(br.readLine());
            makeJBox(size);
        }
        System.out.print(sb);
    }

    public static void makeJBox(int size) {
        for (int i = 1; i <= size; i++) {
            String row = "#".repeat(size);
            if (i > 1 && i < size) {
                row = "#" + "J".repeat(size-2) + "#";
            }
            sb.append(row).append("\n");
        }
        sb.append("\n");
    }
}
