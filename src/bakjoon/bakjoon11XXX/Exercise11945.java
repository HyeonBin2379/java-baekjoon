package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        StringBuilder total = new StringBuilder();
        String[] input = new String[row];
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            input[i] = br.readLine();
            sb.append(input[i]).reverse();
            total.append(sb).append("\n");
        }
        br.close();
        System.out.println(total);
    }
}
