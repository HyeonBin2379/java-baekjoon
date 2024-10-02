package baekjoon.baekjoon20XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise20977 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");
        Arrays.sort(input, (o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else if ((o1.equals("J") && o2.equals("O"))
                    || (o1.equals("O") && o2.equals("I"))
                    || (o1.equals("J") && o2.equals("I"))) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(String.join("", input));
    }
}
