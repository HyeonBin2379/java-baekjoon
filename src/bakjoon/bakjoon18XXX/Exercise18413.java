package bakjoon.bakjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise18413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] count = new int[m+1];
        Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).forEach(value -> count[value]++);
        System.out.println(Arrays.stream(count).reduce(0, Integer::max));
    }
}
