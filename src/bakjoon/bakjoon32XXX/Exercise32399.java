package bakjoon.bakjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise32399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int idx = str.indexOf("1");
        if (idx == 1) {
            System.out.println(str.equals("(1)") ? 0 : 2);
        } else {
            System.out.println(1);
        }
    }
}
