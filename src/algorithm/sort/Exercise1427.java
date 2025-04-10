package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] digits = Arrays.stream(br.readLine().split("")).sorted(Comparator.reverseOrder()).toArray(String[]::new);
        System.out.println(String.join("", digits));
    }
}
