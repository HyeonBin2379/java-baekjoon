package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] blank = {4, 2, 3, 3, 3, 3, 3, 3, 3, 3};
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            int[] num = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(num).map(operand -> blank[operand]).sum();
            sb.append((sum + input.length()+1)).append("\n");
        }
        System.out.print(sb);
    }
}
