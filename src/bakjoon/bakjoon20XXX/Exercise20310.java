package bakjoon.bakjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20310 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int one = 0, zero = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }
        one /= 2;
        zero /= 2;

        StringBuilder sb = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            if (one == 0 && zero == 0) {
                break;
            }
            if (one > 0 && input.charAt(i) == '1') {
                sb.setCharAt(i, ' ');
                one--;
            }
            if (zero > 0 && input.charAt(input.length()-1-i) == '0') {
                sb.setCharAt(input.length()-1-i, ' ');
                zero--;
            }
        }
        System.out.println(sb.toString().replaceAll(" ", ""));
    }
}
