package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Exercise27891 {

    private static final Map<String, String> school = Map.of(
            "northlondoncollegiateschool", "NLCS",
            "branksomehallasia", "BHA",
            "koreainternationalschool", "KIS",
            "stjohnsburyacademy", "SJA"
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine()
                .replaceAll("[^a-zA-Z]", "")
                .toLowerCase();
        for (int i = 0; i < 26; i++) {
            String result = decryptName(input.substring(0, Math.min(10, input.length())), i);
            for (String name : school.keySet()) {
                if (name.startsWith(result)) {
                    System.out.println(school.get(name));
                    return;
                }
            }
        }
    }

    private static String decryptName(String encrypted, int n) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encrypted.toCharArray()) {
            char newChar = (char) ('a' + (c - 'a' + n) % 26);
            decrypted.append(newChar);
        }
        return decrypted.toString();
    }
}
