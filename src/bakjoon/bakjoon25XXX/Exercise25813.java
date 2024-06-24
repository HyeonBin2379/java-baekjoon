package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise25813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int start = input.indexOf("U");
        int end = input.lastIndexOf("F");

        char[] answer = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (i < start || i > end) {
                answer[i] = '-';
            } else if (i > start && i < end) {
                answer[i] = 'C';
            } else {
                answer[i] = input.charAt(i);
            }
        }
        System.out.println(new String(answer));
    }
}
