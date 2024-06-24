package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28290 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        switch (input) {
            case "asdfjkl;" -> System.out.println("stairs");
            case ";lkjfdsa" -> System.out.println("reverse");
            case "fdsajkl;", "jkl;fdsa" -> System.out.println("in-out");
            case "asdf;lkj", ";lkjasdf" -> System.out.println("out-in");
            default -> System.out.println("molu");
        }
        br.close();
    }
}
