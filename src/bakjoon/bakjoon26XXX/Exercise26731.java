package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = br.readLine().chars().map(operand -> operand-'A').sum();
        System.out.println((char)('A' + 325 - sum));
    }
}
