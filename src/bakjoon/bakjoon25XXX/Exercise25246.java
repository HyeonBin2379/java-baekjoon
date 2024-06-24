package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise25246 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        String input = br.readLine();
        int index = 0;
        for (int i = input.length()-1; i >= 0; i--) {
            if (vowels.contains(input.charAt(i))) {
                index = i;
                break;
            }
        }

        System.out.println(input.substring(0, index+1) + "ntry");
    }
}
