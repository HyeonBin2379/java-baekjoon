package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            int lastIndex = input.length()-1;
            int count = (int) input.substring(0, lastIndex).chars().filter(value -> (char)value == '1').count();
            if (count % 2 == 0) {
                input = (input.charAt(lastIndex) == 'e') ? input.substring(0, lastIndex) + "0" : input.substring(0, lastIndex) + "1";
            } else {
                input = (input.charAt(lastIndex) == 'e') ? input.substring(0, lastIndex) + "1" : input.substring(0, lastIndex) + "0";
            }
            System.out.println(input);
        }
    }
}
