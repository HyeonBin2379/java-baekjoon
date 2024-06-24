package bakjoon.bakjoon15XXX;

import java.util.Scanner;

public class Exercise15873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        if (!input.contains("0")) {
            String[] num = input.split("");
            System.out.println(Integer.parseInt(num[0]) + Integer.parseInt(num[1]));
            return;
        }

        switch (input.indexOf("0")) {
            case 1 ->
                    System.out.println(Integer.parseInt(input.substring(0, 2)) + Integer.parseInt(input.substring(2)));
            case 2 ->
                    System.out.println(Integer.parseInt(input.substring(0, 1)) + Integer.parseInt(input.substring(1)));
        }
    }
}
