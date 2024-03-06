package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise9443 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> firstLetter = new LinkedHashSet<>();
        int n = Integer.parseInt(br.readLine());
        char[] letter = new char[n];
        for (int i = 0; i < n; i++) {
            letter[i] = br.readLine().charAt(0);
            firstLetter.add(letter[i]);
        }

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int answer = 0;
        for (int i = 0; i < alphabet.length(); i++) {
            if (!firstLetter.contains(alphabet.charAt(i))) {
                break;
            }
            answer += 1;
        }
        System.out.println(answer);
    }
}
