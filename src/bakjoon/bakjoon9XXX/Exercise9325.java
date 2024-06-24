package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int sum = Integer.parseInt(br.readLine());
            int option = Integer.parseInt(br.readLine());
            for (int j = 0; j < option; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                sum += (count*price);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
