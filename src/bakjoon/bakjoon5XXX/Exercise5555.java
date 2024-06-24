package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5555 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String ring = br.readLine().repeat(2);
            if (ring.contains(target)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
