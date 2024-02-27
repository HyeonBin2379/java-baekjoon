package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        while (true) {
            String operation = br.readLine();
            if (operation.equals("=")) {
                break;
            }
            int num = Integer.parseInt(br.readLine());
            switch (operation) {
                case "+" -> sum += num;
                case "-" -> sum -= num;
                case "*" -> sum *= num;
                case "/" -> sum /= num;
            }
        }
        System.out.println(sum);
    }
}
