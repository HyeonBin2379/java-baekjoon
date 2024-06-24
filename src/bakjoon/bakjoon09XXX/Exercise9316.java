package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise9316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 1; i <= count; i++) {
            bw.write(String.format("Hello World, Judge %d!\n", i));
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
