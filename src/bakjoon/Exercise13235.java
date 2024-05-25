package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13235 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i <= input.length/2; i++) {
            if (input[i] != input[input.length-1-i]) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}
