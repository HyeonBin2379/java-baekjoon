package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum1 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sum();
        long sum2 = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sum();
        System.out.println(sum2 + " " + sum1);
    }
}
