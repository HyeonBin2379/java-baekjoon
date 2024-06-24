package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise31867 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int odd = (int) Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .filter(value -> value % 2 == 1)
                .count();
        int even = n-odd;
        if (odd > even) {
            System.out.println(1);
        } else if (odd == even) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
}
