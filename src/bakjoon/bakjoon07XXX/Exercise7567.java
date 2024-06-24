package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise7567 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] bowls = br.readLine().toCharArray();
        int height = 10;
        for (int i = 1; i < bowls.length; i++) {
            if (bowls[i-1] == bowls[i]) {
                height += 5;
            } else {
                height += 10;
            }
        }
        System.out.println(height);
    }
}
