package bakjoon.bakjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] ucpc = "UCPC".toCharArray();
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ucpc[idx] == str.charAt(i)) {
                idx++;
            }
            if (idx == 4) {
                System.out.println("I love UCPC");
                return;
            }
        }
        System.out.println("I hate UCPC");
    }
}
