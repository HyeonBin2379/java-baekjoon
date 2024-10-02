package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise27880 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] fromTo = {1, 1, 3, 1};
        int height = 0;
        for (int i = 0; i < fromTo.length; i++) {
            String[] token = br.readLine().split(" ");
            height += (token[0].equals("Es")) ? 21*Integer.parseInt(token[1]) : 17*Integer.parseInt(token[1]);
        }
        System.out.println(height);
    }
}
