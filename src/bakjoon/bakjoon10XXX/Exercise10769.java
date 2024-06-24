package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10769 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int happy = 0, sad = 0;
        for (String s : token) {
            for (int j = 0; j < s.length()-2; j++) {
                String now = s.substring(j, j+3);
                if (now.startsWith(":-)")) {
                    happy++;
                } else if (now.startsWith(":-(")) {
                    sad++;
                }
            }
        }
        if (happy == 0 && sad == 0) {
            System.out.println("none");
        } else if (happy < sad) {
            System.out.println("sad");
        } else if (happy > sad) {
            System.out.println("happy");
        } else {
            System.out.println("unsure");
        }
    }
}
