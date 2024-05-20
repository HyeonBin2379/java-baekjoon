package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25551 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mask = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] tShirt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pants = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int min1 = Math.min(Math.min(mask[0], tShirt[1]), pants[0]);
        int min2 = Math.min(Math.min(mask[1], tShirt[0]), pants[1]);
        System.out.println(Math.min(min1, min2+1) + Math.min(min1+1, min2));
    }
}