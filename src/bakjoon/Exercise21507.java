package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class Exercise21507 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal[] num = Arrays.stream(br.readLine().split(" ")).map(BigDecimal::new).toArray(BigDecimal[]::new);
        BigDecimal area = num[0].min(num[1]).add(num[2].min(num[3]));
        System.out.println(area.sqrt(MathContext.DECIMAL128).toBigInteger());
    }
}
