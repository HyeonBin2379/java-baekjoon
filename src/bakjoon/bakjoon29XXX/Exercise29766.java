package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise29766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int count = 0;
        while (input.contains("DKSH")) {
            count++;
            input = input.replaceFirst("DKSH", "XXXX");
        }
        System.out.println(count);
    }
}
