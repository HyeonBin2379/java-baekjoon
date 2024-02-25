package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26736 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int a = (int) input.chars().filter(value -> value == 'A').count();
        System.out.printf("%d : %d\n", a, input.length()-a);
    }
}
