package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise16171 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = Arrays.stream(br.readLine().split(""))
                .filter(s -> !Character.isDigit(s.charAt(0)))
                .collect(Collectors.joining());
        String k = br.readLine();
        System.out.println(str.contains(k) ? 1 : 0);
    }
}
