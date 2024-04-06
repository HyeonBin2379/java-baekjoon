package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27329 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String input = br.readLine();

        if (input.equals(input.substring(0, len/2).repeat(2))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
