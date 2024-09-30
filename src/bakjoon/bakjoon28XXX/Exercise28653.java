package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Exercise28653 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        System.out.println(Arrays.stream((str1+str2).split(""))
                .sorted()
                .collect(Collectors.joining()).substring(0, n));
    }
}
