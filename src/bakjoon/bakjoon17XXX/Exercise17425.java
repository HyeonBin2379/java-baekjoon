package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise17425 {

    private static final long[] prefixSum = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        setArray();
        while (testcase-- > 0) {
            bw.write(prefixSum[Integer.parseInt(br.readLine())] + "\n");
        }
        br.close();
        bw.close();
    }

    private static void setArray() {
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 1; i*j < prefixSum.length; j++) {
                prefixSum[i*j] += i;
            }
            prefixSum[i] += prefixSum[i-1];
        }
    }
}
