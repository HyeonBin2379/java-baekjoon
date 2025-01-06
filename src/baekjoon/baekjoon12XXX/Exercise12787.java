package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise12787 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());

            int[] num = new int[8];
            String binary;
            switch (option) {
                case 1 -> {
                    num = Arrays.stream(st.nextToken().split("\\.")).mapToInt(Integer::parseInt).toArray();
                    binary = Arrays.stream(num)
                            .mapToObj(value -> String.format("%08d", Integer.parseInt(Integer.toBinaryString(value))))
                            .collect(Collectors.joining());
                    bw.write(new BigInteger(binary, 2) + "\n");
                }
                case 2 -> {
                    binary = String.format("%0128d", new BigInteger(new BigInteger(st.nextToken()).toString(2)));
                    int len = binary.length();
                    for (int i = 7; i >= 0; i--) {
                        num[i] = Integer.parseInt(binary.substring(Math.max(len - 8, 0), len), 2);
                        len -= 8;
                    }
                    bw.write(Arrays.stream(num).mapToObj(Integer::toString).collect(Collectors.joining(".")) + "\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
