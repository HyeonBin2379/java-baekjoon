package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Exercise2408 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < 2*n-1; i++) {
            tokens.add(br.readLine());
        }

        BigDecimal result = calculate(tokens);
        System.out.println(result);
    }

    public static BigDecimal calculate(List<String> tokens) {
        List<BigDecimal> num = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        for (int i = 0; i < tokens.size(); i++) {
            if (i % 2 == 0) {
                num.add(new BigDecimal(tokens.get(i)));
            } else {
                operators.add(tokens.get(i));
            }
        }

        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
                BigDecimal result;
                if (operators.get(i).equals("*")) {
                    result = num.get(i).multiply(num.get(i+1));
                } else {
                    result = num.get(i).divide(num.get(i+1), 0, RoundingMode.FLOOR);
                }
                num.set(i, result);
                num.remove(i+1);
                operators.remove(i);
                i--;
            }
        }

        BigDecimal result = num.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("+")) {
                result = result.add(num.get(i+1));
            } else if (operators.get(i).equals("-")) {
                result = result.subtract(num.get(i+1));
            }
        }
        return result;
    }
}
