package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Exercise1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Character> vowel = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        while (true) {
            String input = br.readLine().toLowerCase();
            int count = 0;
            if (input.equals("#")) {
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                if (vowel.contains(input.charAt(i))) {
                    count++;
                }
            }
            bw.write(count+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
