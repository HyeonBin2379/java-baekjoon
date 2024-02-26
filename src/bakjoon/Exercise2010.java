package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += (i < count) ? num-1 : num;
        }
        System.out.println(sum);
    }
}
