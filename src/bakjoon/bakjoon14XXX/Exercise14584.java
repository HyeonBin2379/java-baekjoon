package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14584 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code =  br.readLine();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < 26; j++) {
                String original = decode(code, j);
                if (original.contains(word)) {
                    System.out.println(original);
                    return;
                }
            }
        }
    }

    private static String decode(String code, int gap) {
        StringBuilder sb = new StringBuilder();
        for (char ch : code.toCharArray()) {
            sb.append((char)('a' + (ch-'a'+gap) % 26));
        }
        return sb.toString();
    }
}
