package bakjoon.bakjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32432 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.parseInt(br.readLine());
        System.out.println((min-n+1)/n);
    }
}
