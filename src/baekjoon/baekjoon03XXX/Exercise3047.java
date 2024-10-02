package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] index = br.readLine().chars().map(operand -> operand - 'A').toArray();
        Arrays.sort(num);
        Arrays.stream(index).forEach(value -> System.out.print(num[value] + " "));
    }
}
