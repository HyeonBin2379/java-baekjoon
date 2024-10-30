package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int word = Integer.parseInt(br.readLine());

        int zero = 0, one = 0;
        int repeat = 2;
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    zero++;
                } else {
                    one++;
                }
                if ((word == 0 && zero == t) || (word == 1 && one == t)) {
                    System.out.println((zero+one-1) % a);
                    return;
                }
            }
            for (int i = 0; i < repeat; i++) {
                if (++zero == t && word == 0) {
                    System.out.println((zero+one-1) % a);
                    return;
                }
            }
            for (int i = 0; i < repeat; i++) {
                if (++one == t && word == 1) {
                    System.out.println((zero+one-1) % a);
                    return;
                }
            }
            repeat++;
        }
    }
}
