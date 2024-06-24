package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15272 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) == 's' && input.charAt(i) == input.charAt(i+1)) {
                System.out.println("hiss");
                return;
            }
        }
        System.out.println("no hiss");
    }
}
