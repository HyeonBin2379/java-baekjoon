package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17598 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lion = 0;
        for (int i = 0; i < 9; i++) {
            String vote = br.readLine();
            if (vote.equals("Lion")) {
                lion++;
            }
        }
        System.out.println(lion > 9-lion ? "Lion" : "Tiger");
    }
}
