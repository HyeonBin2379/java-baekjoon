package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10886 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int cute = 0;
        for (int i = 0; i < total; i++) {
            int opinion = Integer.parseInt(br.readLine());
            if (opinion == 1) {
                cute++;
            }
        }
        if (cute > total-cute) {
            System.out.println("Junhee is cute!");
        } else {
            System.out.println("Junhee is not cute!");
        }
    }
}
