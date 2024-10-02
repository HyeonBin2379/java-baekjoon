package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int black = (int) input.chars().filter(socks -> socks == 'B').count();
        System.out.println(black/2 + (input.length()-black)/2);
    }
}
