package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Exercise2729 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger num1 = new BigInteger(st.nextToken(), 2);
            BigInteger num2 = new BigInteger(st.nextToken(), 2);
            sb.append(num1.add(num2).toString(2)).append("\n");
        }
        System.out.print(sb);
    }
}
