package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise23103 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int total = 0;
        for (int i = 1; i < n; i++) {
            int[] next = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            total += Math.abs(next[0]-now[0]) + Math.abs(next[1]-now[1]);
            now = next.clone();
        }
        System.out.println(total);
    }
}
