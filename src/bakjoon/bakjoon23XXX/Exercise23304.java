package bakjoon.bakjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise23304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        System.out.println(palindrome(str) ? "AKARAKA" : "IPSELENTI");
    }

    public static boolean palindrome(String str) {
        if (str.length() == 1) {
            return true;
        }

        int half = str.length() / 2;
        String left = str.substring(0, half);
        String right = (str.length() % 2 == 0) ? str.substring(half) : str.substring(half + 1);
        if (!left.equals(right)) {
            return false;
        }
        return palindrome(left) && palindrome(right);
    }
}
