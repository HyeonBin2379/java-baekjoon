package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26552 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine())+1;
            while (String.valueOf(num).contains("0")) {
                num++;
            }
            System.out.println(num);
        }
    }
}
