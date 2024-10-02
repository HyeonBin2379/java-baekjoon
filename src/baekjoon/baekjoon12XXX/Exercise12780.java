package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise12780 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String h = br.readLine();
        String n = br.readLine();

        int count = 0;
        for (int i = -1; i != 0 && i <= h.length(); i++) {
            i = h.indexOf(n, i);
            if (i != -1) {
                count++;
            }
        }
        System.out.println(count);
    }
}
