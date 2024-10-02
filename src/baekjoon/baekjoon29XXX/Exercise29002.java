package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] force = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int total = Arrays.stream(force).sum();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (total-force[i] != force[i]) {
                System.out.print(force[i] + " ");
            } else {
                sum = force[i];
            }
        }
        System.out.println(sum);
    }
}
