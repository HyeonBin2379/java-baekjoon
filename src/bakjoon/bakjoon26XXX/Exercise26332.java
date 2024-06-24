package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26332 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int customer = Integer.parseInt(br.readLine());

        for (int i = 0; i < customer; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int count = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            sb.append(input).append("\n");
            sb.append(cost + (count-1)*(cost-2)).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}
