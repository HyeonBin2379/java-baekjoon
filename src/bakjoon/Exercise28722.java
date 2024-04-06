package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.charAt(0) == input.charAt(input.length()-1)) {
            System.out.println("Lose");
        } else {
            System.out.println("Win");
        }
    }
}
