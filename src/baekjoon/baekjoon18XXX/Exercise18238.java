package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise18238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char start = 'A';
        int time = 0;
        for (char c : input) {
            int temp = Math.abs(c - start);
            time += Math.min(temp, 26 - temp);
            start = c;
        }
        System.out.println(time);
    }
}
