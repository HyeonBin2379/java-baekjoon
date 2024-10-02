package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise9613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            long[] countAndNumbers = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            List<Long> result = new ArrayList<>();
            for (int j = 1; j < countAndNumbers.length-1; j++) {
                for (int k = j+1; k < countAndNumbers.length; k++) {
                    long max = Math.max(countAndNumbers[j], countAndNumbers[k]);
                    long min = Math.min(countAndNumbers[j], countAndNumbers[k]);
                    result.add(gcd(max, min));
                }
            }
            bw.write(result.stream().mapToLong(value -> value).sum() + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static long gcd(long num1, long num2) {
        while (num2 != 0) {
            long temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}
