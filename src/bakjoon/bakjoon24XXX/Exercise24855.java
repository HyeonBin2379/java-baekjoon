package bakjoon.bakjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24855 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int half = Arrays.stream(price, 0, (int) Math.ceil((double) n / 2)).sum();
        System.out.println(Arrays.stream(price).sum() - half);
    }
}
