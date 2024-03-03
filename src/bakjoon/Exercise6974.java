package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise6974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            BigInteger a = new BigInteger(br.readLine());
            BigInteger b = new BigInteger(br.readLine());
            BigInteger[] answer = a.divideAndRemainder(b);
            sb.append(answer[0]).append("\n");
            sb.append(answer[1]).append("\n").append("\n");
        }
        System.out.print(sb);
    }
}
