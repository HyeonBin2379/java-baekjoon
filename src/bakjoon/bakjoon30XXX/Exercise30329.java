package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise30329 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'k') {
                if (input.startsWith("kick", i)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
