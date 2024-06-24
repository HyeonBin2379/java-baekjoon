package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] check = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0, continuous = 0;
        for (int i = 0; i < count; i++) {
            if (check[i] == 1) {
                continuous++;
                sum += continuous;
            } else {
                continuous = 0;
            }
        }
        System.out.println(sum);
    }
}
