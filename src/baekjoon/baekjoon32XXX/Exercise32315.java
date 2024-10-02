package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise32315 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split("-");
        long count = Arrays.stream(token)
                .flatMap(s -> Arrays.stream(s.split("")))
                .mapToInt(Integer::parseInt)
                .distinct()
                .count();
        System.out.println(count);
    }
}
