package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int count = Integer.parseInt(br.readLine());
            double sum = 0d;
            for (int j = 0; j < count; j++) {
                String[] orderInfo = br.readLine().split(" ");
                sum += Double.parseDouble(orderInfo[1]) * Double.parseDouble(orderInfo[2]);
            }
            sb.append(String.format("$%.2f\n", sum));
        }
        br.close();
        System.out.print(sb);
    }
}
