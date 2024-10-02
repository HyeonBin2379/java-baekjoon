package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            sb.append(input);
        }
        int[] num = Arrays.stream(sb.toString().split(","))
                .mapToInt(Integer::parseInt).filter(value -> value > 0)
                .toArray();
        System.out.println(Arrays.stream(num).sum());
    }
}