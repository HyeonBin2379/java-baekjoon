package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise20937 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] size = new int[50001];
        Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).forEach(i -> size[i]++);
        System.out.println(Arrays.stream(size).reduce(0, Integer::max));
    }
}
