package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Exercise25773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(br.readLine().split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }
}
