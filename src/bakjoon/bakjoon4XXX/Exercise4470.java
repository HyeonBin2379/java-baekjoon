package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Exercise4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger count = new BigInteger(br.readLine());
        while (!count.equals(BigInteger.ZERO)) {
            String name = br.readLine().toLowerCase();
            bw.write(name + "\n");
            count = count.subtract(BigInteger.ONE);
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
