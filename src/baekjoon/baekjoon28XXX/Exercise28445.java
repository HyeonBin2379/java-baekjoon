package baekjoon.baekjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Exercise28445 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> colors = new TreeSet<>();
        for (int i = 0; i < 2; i++) {
            colors.addAll(Arrays.asList(br.readLine().split(" ")));
        }

        Set<String> combinations = new TreeSet<>();
        for (String father : colors) {
            for (String mother : colors) {
                combinations.add(String.format("%s %s", father, mother));
            }
        }
        combinations.forEach(System.out::println);
    }
}
