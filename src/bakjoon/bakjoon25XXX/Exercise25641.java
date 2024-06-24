package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise25641 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int s =  (int) Arrays.stream(input.split("")).filter(s1 -> s1.equals("s")).count();
        int t = len - s;
        for (int i = 0; i < len; i++) {
            if (s == t) {
                System.out.println(input.substring(i));
                break;
            }
            if (input.charAt(i) == 's') {
                s--;
            } else {
                t--;
            }
        }
    }
}
