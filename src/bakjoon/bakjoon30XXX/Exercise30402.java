package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise30402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> pixel = new HashSet<>();
        String[][] input = new String[15][];
        for (int i = 0; i < 15; i++) {
            input[i] = br.readLine().split(" ");
            pixel.addAll(Arrays.asList(input[i]));
        }

        if (pixel.contains("w")) {
            System.out.println("chunbae");
        } else if (pixel.contains("b")) {
            System.out.println("nabi");
        } else if (pixel.contains("g")) {
            System.out.println("yeongcheol");
        }
    }
}
