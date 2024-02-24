package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise25932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String input = br.readLine();
            bw.write(input + "\n");
            if (input.contains("18")) {
                bw.write(input.contains("17") ? "both\n\n" : "mack\n\n");
            } else {
                bw.write(input.contains("17") ? "zack\n\n" : "none\n\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
