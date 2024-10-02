package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5586 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int joi = 0, ioi = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'J') {
                joi += (input.substring(i).startsWith("JOI")) ? 1 : 0;
            } else if (input.charAt(i) == 'I') {
                ioi += (input.substring(i).startsWith("IOI")) ? 1 : 0;
            }
        }
        System.out.println(joi + "\n" + ioi);
    }
}
