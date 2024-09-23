package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4176 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("END")) {
                break;
            }

            int i = 1;
            while(true) {
                String next = String.valueOf(input.length());
                if (input.equals(next)) {
                    break;
                }
                input = next;
                i++;
            }
            System.out.println(i);
        }
    }
}
