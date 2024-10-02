package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2028 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int base = Integer.parseInt(br.readLine());
            String square = Integer.toString(base*base);
            int len = square.length();
            System.out.println(Integer.parseInt(square.substring(len/2)) == base ? "YES" : "NO");
        }
    }
}
