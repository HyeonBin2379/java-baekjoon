package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise31520 {
    private static final Set<String> champernowne = new LinkedHashSet<>(Arrays.asList(
            "1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789"
    ));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(champernowne.contains(input) ? input.length() : -1);
    }
}
