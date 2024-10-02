package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9664 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int o = Integer.parseInt(br.readLine());
        int di = o/(n-1);
        int min, max;
        if (o % (n-1) == 0) {
            min = o+di-1;
            max = o+di;
        } else {
            max = o+di;
            min = max;
        }
        System.out.println(min + " " + max);
    }
}
