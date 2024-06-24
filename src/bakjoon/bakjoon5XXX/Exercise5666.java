package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5666 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int h = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            sb.append(String.format("%.2f\n", (double)h/p));
        }
        System.out.print(sb);
    }
}
