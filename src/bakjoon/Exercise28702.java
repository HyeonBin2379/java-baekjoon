package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fizzBuzz = new String[3];
        for (int i = 0; i < 3; i++) {
            fizzBuzz[i] = br.readLine();
        }

        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            if (Character.isDigit(fizzBuzz[i].charAt(0))) {
                switch (i) {
                    case 0 -> {
                        num[i] = Integer.parseInt(fizzBuzz[i]);
                        num[i + 1] = num[i] + 1;
                        num[i + 2] = num[i + 1] + 1;
                    }
                    case 1 -> {
                        num[i] = Integer.parseInt(fizzBuzz[i]);
                        num[i - 1] = num[i] - 1;
                        num[i + 1] = num[i] + 1;
                    }
                    case 2 -> {
                        num[i] = Integer.parseInt(fizzBuzz[i]);
                        num[i - 1] = num[i] - 1;
                        num[i - 2] = num[i - 1] - 1;
                    }
                }
                break;
            }
        }
        int lastNum = num[2]+1;
        if (lastNum % 3 == 0) {
            System.out.println(lastNum % 5 == 0 ? "FizzBuzz" : "Fizz");
        } else {
            System.out.println(lastNum % 5 == 0 ? "Buzz" : lastNum);
        }
    }
}
