package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise24198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0;
        int turn = 0;
        while (n > 0) {
            int half = (n % 2 == 0) ? n/2 : n/2+1;
            if (turn % 2 == 0) {
                b += half;
            } else {
                a += half;
            }
            n -= half;
            turn++;
        }
        System.out.println(a + " " + b);
    }
}
