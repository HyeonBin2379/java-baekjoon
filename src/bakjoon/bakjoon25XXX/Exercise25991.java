package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        double[] len = Arrays.stream(br.readLine().split(" ", count)).mapToDouble(Double::parseDouble).toArray();
        double sum = Arrays.stream(len).map(value -> Math.pow(value, 3)).sum();
        System.out.println(Math.cbrt(sum));
        br.close();
    }
}
