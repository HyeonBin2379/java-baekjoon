package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17548 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hey = br.readLine();
        hey = hey.replace(hey.substring(1, hey.length()-1), "e".repeat((hey.length()-2)*2));
        System.out.println(hey);
    }
}
