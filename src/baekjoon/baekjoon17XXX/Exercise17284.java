package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise17284 {

    private static final int[] price = {500, 800, 1000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int change = 5000;
        while (st.hasMoreTokens()) {
            change -= price[Integer.parseInt(st.nextToken())-1];
        }
        System.out.println(change);
    }
}
