package bakjoon.bakjoon6XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6784 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] respond = new String[n];
        for (int i = 0; i < n; i++) {
            respond[i] = br.readLine();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            String answer = br.readLine();
            if (answer.equals(respond[i])) {
                count++;
            }
        }
        System.out.println(count);
    }
}
