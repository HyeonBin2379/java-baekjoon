package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28255 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int len = (int) Math.ceil(input.length()/3.0);
            String prefix = input.substring(0, len);
            System.out.println(isTriple(input, prefix) ? 1 : 0);
        }
    }

    private static boolean isTriple(String original, String prefix) {
        String reverse = new StringBuilder(prefix).reverse().toString();
        return original.equals(prefix + reverse + prefix)
                || original.equals(prefix + reverse.substring(1) + prefix)
                || original.equals(prefix + reverse + prefix.substring(1))
                || original.equals(prefix + reverse.substring(1) + prefix.substring(1));
    }
}
