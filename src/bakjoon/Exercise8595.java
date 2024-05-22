package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8595 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = Arrays.stream(br.readLine().toLowerCase().split("[a-z]"))
                .filter(s -> !s.isEmpty())
                .mapToLong(Long::parseLong)
                .sum();
        System.out.println(sum);
    }
}