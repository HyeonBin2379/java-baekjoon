package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26529 {
    private static int[] bunny;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        getCount();
        for (int i = 0; i < testCase; i++) {
            int month = Integer.parseInt(br.readLine());
            System.out.println(bunny[month]);
        }
    }

    public static void getCount() {
        bunny = new int[46];
        bunny[0] = 1;
        bunny[1] = 1;
        for (int i = 2; i < bunny.length; i++) {
            bunny[i] = bunny[i-1]+bunny[i-2];
        }
    }
}
