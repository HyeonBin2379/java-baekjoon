package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4539 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 1; j < Integer.toString(num).length(); j++) {
                int pow = (int) Math.pow(10, j);
                num = (int) Math.round((double)num/pow) * pow;
            }
            System.out.println(num);
        }
    }
}
