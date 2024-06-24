package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bit = br.readLine();
        br.close();

        String[] zero = Arrays.stream(bit.split("1")).filter(s -> !s.isEmpty()).toArray(String[]::new);
        String[] one = Arrays.stream(bit.split("0")).filter(s -> !s.isEmpty()).toArray(String[]::new);
        System.out.println(Math.min(zero.length, one.length));
    }
}
