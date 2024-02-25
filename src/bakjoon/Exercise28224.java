package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int price = Integer.parseInt(br.readLine());
        for (int i = 0; i < days-1; i++) {
            price += Integer.parseInt(br.readLine());
        }
        System.out.println(price);
    }
}
