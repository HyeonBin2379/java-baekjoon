package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise29108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String login = br.readLine();
        if (login.startsWith("io")) {
            if (login.length() > 2 && isNumber(login.substring(2))) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        } else {
            System.out.println("Incorrect");
        }
    }

    private static boolean isNumber(String str) {
        return str.chars().allMatch(value -> Character.isDigit((char)value));
    }
}
