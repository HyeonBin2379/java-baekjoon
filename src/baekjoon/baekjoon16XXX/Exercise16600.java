package baekjoon.baekjoon16XXX;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Exercise16600 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal square = new BigDecimal(sc.nextLine());
        System.out.printf("%.6f\n", square.sqrt(MathContext.DECIMAL64).multiply(BigDecimal.valueOf(4.0)));
    }
}
