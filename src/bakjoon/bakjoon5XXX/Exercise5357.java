package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise5357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] letter = br.readLine().split("");
            StringBuilder sb = new StringBuilder(letter[0]);
            for (int j = 1; j < letter.length; j++) {
                if (!letter[j].equals(letter[j-1])) {
                    sb.append(letter[j]);
                }
            }
            bw.write(sb + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
