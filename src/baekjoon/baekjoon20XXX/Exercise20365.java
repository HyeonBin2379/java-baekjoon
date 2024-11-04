package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise20365 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        while (input.contains("BB") || input.contains("RR")) {
            if (input.contains("BB")) {
                input = input.replace("BB", "B");
            }
            if (input.contains("RR")) {
                input = input.replace("RR", "R");
            }
        }
        int bCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'B') {
                bCnt++;
            }
        }
        System.out.println(1+Math.min(bCnt, input.length()-bCnt));
    }
}
