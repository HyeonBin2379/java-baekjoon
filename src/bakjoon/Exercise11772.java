package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise11772 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;
        for (int i = 0; i < n; i++) {
            String num = br.readLine();
            int base = Integer.parseInt(num.substring(0,num.length()-1));
            int exp = Integer.parseInt(num.substring(num.length()-1));
            sum += Math.pow(base, exp);
        }
        System.out.println(sum);
    }
}
