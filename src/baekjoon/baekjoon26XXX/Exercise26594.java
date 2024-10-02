package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26594 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int count = 1;
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) != input.charAt(i+1)) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
