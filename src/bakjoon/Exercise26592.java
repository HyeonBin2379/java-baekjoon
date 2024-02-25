package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double s = Double.parseDouble(st.nextToken());
            double w = Double.parseDouble(st.nextToken());
            sb.append(String.format("The height of the triangle is %.2f units\n", s*2/w));
        }
        br.close();
        System.out.print(sb);
    }
}
