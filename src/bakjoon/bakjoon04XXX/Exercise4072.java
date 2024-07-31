package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise4072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            String[] words = input.split(" ");
            System.out.println(Arrays.stream(words)
                    .map(s -> new StringBuilder(s).reverse())
                    .collect(Collectors.joining(" ")));
        }
    }
}
