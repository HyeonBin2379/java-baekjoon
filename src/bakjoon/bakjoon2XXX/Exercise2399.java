package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        long[] num = Arrays.stream(br.readLine().split(" ", len)).mapToLong(Long::parseLong).toArray();
        long sum = 0;
        for (long value : num) {
            for (long l : num) {
                sum += Math.abs(value - l);
            }
        }
        System.out.println(sum);
    }
}
