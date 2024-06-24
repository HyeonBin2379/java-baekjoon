package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise30868 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int candidate = Integer.parseInt(br.readLine());
        for (int i = 0; i < candidate; i++) {
            int count = Integer.parseInt(br.readLine());
            String output = "|".repeat(count);
            while (output.contains("|||||")) {
                output = output.replaceFirst("[|]{5}", "++++ ");
            }
            bw.write(output + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
