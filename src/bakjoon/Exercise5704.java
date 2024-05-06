package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise5704 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("*")) {
                break;
            }
            Set<Character> pengram = new HashSet<>();
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != ' ') {
                    pengram.add(input.charAt(i));
                }
            }
            System.out.println(pengram.size() == 26 ? "Y" : "N");
        }
    }
}
