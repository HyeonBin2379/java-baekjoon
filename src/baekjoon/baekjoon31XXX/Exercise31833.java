package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Exercise31833 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str1 = String.join("", br.readLine().split(" "));
        BigInteger num1 = new BigInteger(str1);
        String str2 = String.join("", br.readLine().split(" "));
        BigInteger num2 = new BigInteger(str2);
        System.out.println(num1.min(num2));
    }
}
