package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise11576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] digit = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();
        System.out.println(toBase(toDecimal(digit, a), b));
    }

    private static int toDecimal(int[] digit, int base) {
        return IntStream.rangeClosed(0, digit.length-1)
                .map(i -> digit[digit.length-1-i]*(int)Math.pow(base, i))
                .sum();
    }

    private static String toBase(int decimal, int base) {
        List<String> result = new ArrayList<>();
        while (decimal > 0) {
            result.add(Integer.toString(decimal % base));
            decimal /= base;
        }
        return IntStream.iterate(result.size()-1, i -> i >= 0, i -> i-1)
                .mapToObj(result::get)
                .collect(Collectors.joining(" "));
    }
}
