package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise16431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] bessie = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] daisy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] john = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int b_count = Math.max(Math.abs(bessie[0]-john[0]), Math.abs(bessie[1]-john[1]));
        int d_count = Math.abs(john[0]-daisy[0]) + Math.abs(john[1]-daisy[1]);
        if (b_count > d_count) {
            System.out.println("daisy");
        } else if (b_count < d_count) {
            System.out.println("bessie");
        } else {
            System.out.println("tie");
        }
    }
}
