package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise17010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lineCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < lineCount; i++) {
            String[] token = br.readLine().split(" ");
            bw.write(token[1].repeat(Integer.parseInt(token[0])) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
