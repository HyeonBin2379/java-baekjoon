package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            s.append(a.charAt(i));
            s.append(b.charAt(i));
        }
        while (s.length() > 2) {
            StringBuilder newNum = new StringBuilder();
            int[] num = Arrays.stream(s.toString().split("")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < num.length-1; i++) {
                newNum.append((num[i] + num[i + 1]) % 10);
            }
            s = new StringBuilder(newNum.toString());
        }
        System.out.println(s);
    }
}
