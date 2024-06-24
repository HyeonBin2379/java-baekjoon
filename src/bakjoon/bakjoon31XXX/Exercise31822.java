package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String retake = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (name.startsWith(retake.substring(0, 5))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
