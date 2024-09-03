package bakjoon.bakjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise16787 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int count = 0;
        for (int i = 0; i < input.length();) {
            if (input.startsWith("OX", i) || input.startsWith("XO", i)) {
                i += 2;
                count++;
                continue;
            }
            i++;
        }
        System.out.println(count);
    }
}
