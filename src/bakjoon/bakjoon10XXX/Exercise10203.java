package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise10203 {

    private static final String vowels = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String str = br.readLine();
            long count = Arrays.stream(str.split("")).filter(vowels::contains).count();
            sb.append(String.format("The number of vowels in %s is %d.\n", str, count));
        }
        System.out.print(sb);
    }
}
