package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17350 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        for (int i = 0; i < len; i++) {
            String name = br.readLine().toLowerCase();
            if (name.equals("anj")) {
                System.out.println("뭐야;");
                return;
            }
        }
        System.out.println("뭐야?");
    }
}
