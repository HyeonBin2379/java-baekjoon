package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long max = 1;
        for (long i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                max = num/i;
                break;
            }
        }
        System.out.println(num-max);
    }
}
